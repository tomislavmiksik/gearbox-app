package de.comsystoreply.gearbox

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class GearboxApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        // Log configuration info in debug builds
        if (BuildConfig.DEBUG) {
            try {
                val configClass = Class.forName("de.comsystoreply.gearbox.debug.ConfigDebugInfo")
                val method = configClass.getMethod("logConfigInfo", android.content.Context::class.java)
                method.invoke(null, this)
            } catch (e: Exception) {
                Timber.d("Debug config info not available in this build variant")
            }
        }
    }
}