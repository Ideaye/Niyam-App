package com.myniyam.app.update

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability

/**
 * Play In-App Updates, flexible flow — the soft sibling of the RemoteConfig
 * force-update gate. When Play has a newer build, the user sees Play's own
 * (localized) update sheet; on accept, the download runs in the background and
 * the update is applied at the next cold start. Zero custom strings.
 *
 * Entirely best-effort: a debug/sideloaded install, a device without Play, or
 * any Play Services hiccup is a silent no-op — the app must never depend on
 * this path. The hard lever for broken builds remains min_supported_version_code.
 */
object InAppUpdater {

    private const val TAG = "InAppUpdater"

    /**
     * Apply a flexible update that finished downloading in a previous session.
     * Call from MainActivity.onCreate BEFORE [checkAndPrompt]; restarts the
     * process when an update is staged (standard flexible-flow completion).
     */
    fun completePendingUpdate(activity: ComponentActivity) {
        try {
            val mgr = AppUpdateManagerFactory.create(activity)
            mgr.appUpdateInfo.addOnSuccessListener { info ->
                if (info.installStatus() == InstallStatus.DOWNLOADED) {
                    Log.i(TAG, "flexible update downloaded — completing")
                    mgr.completeUpdate()
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "completePendingUpdate no-op", e)
        }
    }

    /** Ask Play whether an update exists; if so, show the flexible sheet. */
    fun checkAndPrompt(
        activity: ComponentActivity,
        launcher: ActivityResultLauncher<IntentSenderRequest>
    ) {
        try {
            val mgr = AppUpdateManagerFactory.create(activity)
            mgr.appUpdateInfo.addOnSuccessListener { info ->
                val available = info.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                if (available && info.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                    try {
                        mgr.startUpdateFlowForResult(
                            info, launcher, AppUpdateOptions.defaultOptions(AppUpdateType.FLEXIBLE)
                        )
                    } catch (e: Exception) {
                        Log.w(TAG, "update flow launch failed", e)
                    }
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "checkAndPrompt no-op", e)
        }
    }
}
