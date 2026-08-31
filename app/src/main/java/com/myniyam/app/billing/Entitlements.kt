package com.myniyam.app.billing

import com.myniyam.app.data.DisplayLanguage

/** Premium tier the user is currently in (spec §3.1). */
enum class PremiumState { PREMIUM, TRIAL, FREE }

/**
 * Pure entitlement logic (spec §3.1) — no android imports, fully unit-testable.
 * Callers pass the clock (epoch days) so trial math survives wall-clock changes.
 */
object Entitlements {

    /**
     * Master monetization switch (founder decision 2026-08-31). While true,
     * Niyam is free for everyone: [state] reports PREMIUM for every user, which
     * opens every gate that keys off the entitlement state (library/detail
     * locks, language locks, ad gates, trial UI) and silences the trial
     * reminder. Trial seeding, launch entitlement reconciliation and billing
     * self-heal are also gated on this flag at their call sites. The paid
     * machinery below stays intact and dormant — to bring the paid tier back,
     * flip this to false AND refresh the Play listing/Data Safety + website
     * legal copy, recreate the Play subscription products, and decide the
     * grandfather policy for users who joined while the app was free.
     */
    const val FREE_FOR_ALL = true

    /** First-priority mantra per intention, free forever (spec §1). Build default. */
    val FREE_MANTRA_IDS: Set<String> = setOf(
        "gita-2-47",
        "mahamrityunjaya",
        "gayatri",
        "gita-4-7-8",
        "hanuman-chalisa-opening"
    )

    /**
     * The free set actually in effect. Defaults to the build's [FREE_MANTRA_IDS];
     * RemoteConfig overwrites it on launch so the free tier can change without a
     * build (OTA). Pure value — no android, always non-empty.
     */
    @Volatile
    var activeFreeMantraIds: Set<String> = FREE_MANTRA_IDS

    /** Display languages available without premium (spec §1). */
    val FREE_LANGUAGES: Set<DisplayLanguage> = setOf(
        DisplayLanguage.ENGLISH,
        DisplayLanguage.HINDI
    )

    const val TRIAL_DAYS = 7

    /**
     * PREMIUM if purchased; TRIAL if within [TRIAL_DAYS] of a started trial
     * (exclusive boundary, and only when today is not before the start so a
     * clock rollback can't grant an infinite trial); otherwise FREE.
     *
     * [freeForAll] defaults to the build's [FREE_FOR_ALL] switch; tests pass
     * false explicitly to exercise the dormant paid-tier logic.
     */
    fun state(
        premiumActive: Boolean,
        trialStartEpochDay: Long,
        todayEpochDay: Long,
        freeForAll: Boolean = FREE_FOR_ALL
    ): PremiumState {
        if (freeForAll) return PremiumState.PREMIUM
        if (premiumActive) return PremiumState.PREMIUM
        val started = trialStartEpochDay != 0L
        val withinWindow = todayEpochDay >= trialStartEpochDay &&
            todayEpochDay - trialStartEpochDay < TRIAL_DAYS
        return if (started && withinWindow) PremiumState.TRIAL else PremiumState.FREE
    }

    fun isPremiumExperience(state: PremiumState): Boolean = state != PremiumState.FREE

    /** Grandfather rule: the current sadhana mantra always stays usable (spec §2). */
    fun canUseMantra(state: PremiumState, mantraId: String, currentMantraId: String): Boolean =
        isPremiumExperience(state) || mantraId in activeFreeMantraIds || mantraId == currentMantraId

    /** Grandfather rule: the current display language always stays usable (spec §2). */
    fun canUseLanguage(state: PremiumState, lang: DisplayLanguage, currentLang: DisplayLanguage): Boolean =
        isPremiumExperience(state) || lang in FREE_LANGUAGES || lang == currentLang

    /** Whole days remaining in the trial; 0 when unset, elapsed, or after a clock rollback. */
    fun trialDaysLeft(trialStartEpochDay: Long, todayEpochDay: Long): Int {
        if (trialStartEpochDay == 0L) return 0
        if (todayEpochDay < trialStartEpochDay) return 0
        val elapsed = todayEpochDay - trialStartEpochDay
        if (elapsed >= TRIAL_DAYS) return 0
        return (TRIAL_DAYS - elapsed).toInt()
    }
}
