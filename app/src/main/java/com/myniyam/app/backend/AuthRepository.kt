package com.myniyam.app.backend

import android.content.Context
import com.myniyam.app.data.UserPrefs
import com.myniyam.app.progress.ProgressRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.status.SessionStatus
import io.github.jan.supabase.functions.functions
import kotlinx.coroutines.flow.StateFlow

/**
 * Thin wrapper over Supabase Auth (SP-P3). Session is persisted by supabase-kt;
 * NONE of this is on the blocking-engine path — the engine reads local UserPrefs.
 */
object AuthRepository {

    private val auth get() = SupabaseClientProvider.client.auth

    /** Observable auth state (Authenticated / NotAuthenticated / loading). */
    val sessionStatus: StateFlow<SessionStatus> get() = auth.sessionStatus

    fun isSignedIn(): Boolean = auth.currentSessionOrNull() != null

    fun currentEmail(): String? = auth.currentUserOrNull()?.email

    fun currentUserId(): String? = auth.currentUserOrNull()?.id

    /**
     * Sign out AND wipe all local user-scoped state (audit C1). Local prefs and
     * practice history are user-scoped, not device-scoped, so they must never
     * survive an identity change into the next account on the same device. Every
     * sign-out path routes through here, so the wipe can never be forgotten.
     */
    suspend fun signOut(context: Context) {
        // Wipe local state BEFORE ending the session. Clearing onboardingComplete
        // first makes the post-sign-out NotAuthenticated emission inert to the
        // AppNavHost sign-in gate, so a gate-triggered navigation can't tear down
        // the calling composable (and skip the wipe) mid-sign-out. Also strictly
        // safer: if auth.signOut() ever throws, local is already clean for the
        // same user and the next launch re-syncs — no cross-account leak window.
        wipeLocalUserState(context)
        auth.signOut()
    }

    /**
     * Permanently delete the signed-in user's server account (P3b). Invokes the
     * `delete-account` Edge Function, which verifies the caller's JWT and uses
     * the service_role key (server-only) to delete the auth user; the DB tables
     * cascade-delete via their FK to auth.users. The function call carries the
     * session bearer token automatically. After a successful return we sign out
     * and wipe local state. Throws on failure (caller handles) — a server-delete
     * failure never reaches the sign-out/wipe, so the account stays intact.
     */
    suspend fun deleteAccount(context: Context) {
        // Server-delete first (needs the live JWT), then wipe local state before
        // ending the session — same ordering rationale as signOut so the wipe is
        // never skipped by a gate-triggered teardown.
        SupabaseClientProvider.client.functions.invoke("delete-account")
        wipeLocalUserState(context)
        auth.signOut()
    }

    /**
     * Tear down every local user-scoped store (DataStore prefs + Room practice
     * history) so nothing leaks across accounts on a shared device. The single
     * teardown authority — shared by [signOut] and [deleteAccount]. Not on the
     * engine hot path.
     */
    private suspend fun wipeLocalUserState(context: Context) {
        UserPrefs.clearAll(context)
        ProgressRepository.clearAll(context)
        // Analytics identity must not survive an identity change either.
        com.myniyam.app.telemetry.Telemetry.reset()
    }
}
