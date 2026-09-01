package com.myniyam.app.telemetry

import android.app.Application
import android.content.Context
import android.util.Log
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.myniyam.app.BuildConfig
import com.posthog.PostHog
import com.posthog.android.PostHogAndroid
import com.posthog.android.PostHogAndroidConfig

/**
 * The ONLY doorway for analytics in Niyam. Hard rules (Play accessibility
 * policy + our own prominent disclosure; enforced by review, not just habit):
 *
 *  1. NOTHING under service/, overlay/, or any code on the blocking path may
 *     call this object. Accessibility-derived data — which app was opened or
 *     blocked, and when — must never reach an analytics SDK.
 *  2. No event may ever carry another app's identity. Niyam mantra ids are
 *     fine; package names of other apps are not.
 *  3. Events are the explicit allowlist below. No autocapture, no session
 *     replay, no lifecycle auto-events, no screen tracking.
 *
 * Every SDK is dormant until its key exists in ~/.gradle/gradle.properties
 * (NIYAM_POSTHOG_API_KEY / NIYAM_META_APP_ID [+ client token]; Crashlytics
 * activates via app/google-services.json). A build without keys collects
 * nothing at all.
 */
object Telemetry {

    private const val TAG = "Telemetry"
    @Volatile private var posthogReady = false

    /** Call once from NiyamApplication.onCreate. Cheap no-op without keys. */
    fun init(context: Context) {
        try {
            if (BuildConfig.POSTHOG_API_KEY.isNotBlank()) {
                val config = PostHogAndroidConfig(
                    apiKey = BuildConfig.POSTHOG_API_KEY,
                    host = BuildConfig.POSTHOG_HOST
                ).apply {
                    // Allowlist-only capture (rule 3).
                    captureApplicationLifecycleEvents = false
                    captureDeepLinks = false
                    captureScreenViews = false
                }
                PostHogAndroid.setup(context, config)
                posthogReady = true
            }
        } catch (e: Exception) {
            Log.w(TAG, "PostHog init failed; analytics disabled", e)
        }
        try {
            if (BuildConfig.META_APP_ID.isNotBlank()) {
                // Founder-approved install attribution (2026-09-01). Manifest
                // flags default OFF; this is the single documented activation.
                FacebookSdk.setAutoInitEnabled(true)
                FacebookSdk.fullyInitialize()
                FacebookSdk.setAutoLogAppEventsEnabled(true)
                FacebookSdk.setAdvertiserIDCollectionEnabled(true)
                AppEventsLogger.activateApp(context.applicationContext as Application)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Meta SDK init failed; attribution disabled", e)
        }
    }

    /** Ties events to the Supabase user id (already our identity anchor). */
    fun identify(userId: String) {
        if (posthogReady) try { PostHog.identify(userId) } catch (e: Exception) { Log.w(TAG, "identify", e) }
    }

    /** Call on sign-out / account deletion so the next user starts clean. */
    fun reset() {
        if (posthogReady) try { PostHog.reset() } catch (e: Exception) { Log.w(TAG, "reset", e) }
    }

    private fun capture(event: String, props: Map<String, Any> = emptyMap()) {
        if (posthogReady) try { PostHog.capture(event, properties = props) } catch (e: Exception) { Log.w(TAG, "capture $event", e) }
    }

    // ---- Event allowlist (rule 3). Add here + wire in app UI only. ----

    fun signinCompleted() = capture("signin_completed")
    fun onboardingCompleted() = capture("onboarding_completed")
    fun mantraSwitched(mantraId: String) = capture("mantra_switched", mapOf("mantra_id" to mantraId))
    fun journeyCompleted() = capture("journey_completed")
    fun languageChanged(language: String) = capture("language_changed", mapOf("language" to language))
}
