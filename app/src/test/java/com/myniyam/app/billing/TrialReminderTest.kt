package com.myniyam.app.billing

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TrialReminderTest {

    private val start = 1_000L

    @Test
    fun `never reminds under the free-for-all build default`() {
        // Live-build behavior: with FREE_FOR_ALL on, even a would-be day-6
        // reminder stays silent (state reports PREMIUM). Guards updated tester
        // devices whose worker is already scheduled.
        assertTrue(Entitlements.FREE_FOR_ALL)
        assertFalse(TrialReminder.shouldRemind(false, start, start + 6, alreadyShown = false))
    }

    // --- dormant paid-tier logic (freeForAll = false) ---

    @Test
    fun `reminds on day 6 — one day left`() {
        assertTrue(TrialReminder.shouldRemind(false, start, start + 6, alreadyShown = false, freeForAll = false))
    }

    @Test
    fun `does not remind mid-trial`() {
        assertFalse(TrialReminder.shouldRemind(false, start, start + 3, alreadyShown = false, freeForAll = false))
    }

    @Test
    fun `does not remind after trial ends`() {
        assertFalse(TrialReminder.shouldRemind(false, start, start + 7, alreadyShown = false, freeForAll = false))
    }

    @Test
    fun `never reminds premium users`() {
        assertTrue(Entitlements.state(true, start, start + 6, freeForAll = false) == PremiumState.PREMIUM)
        assertFalse(TrialReminder.shouldRemind(true, start, start + 6, alreadyShown = false, freeForAll = false))
    }

    @Test
    fun `never reminds when no trial started`() {
        assertFalse(TrialReminder.shouldRemind(false, 0L, 6L, alreadyShown = false, freeForAll = false))
    }

    @Test
    fun `never reminds twice`() {
        assertFalse(TrialReminder.shouldRemind(false, start, start + 6, alreadyShown = true, freeForAll = false))
    }
}
