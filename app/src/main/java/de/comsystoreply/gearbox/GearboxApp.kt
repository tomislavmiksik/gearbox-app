package de.comsystoreply.gearbox

import android.app.Application
import de.comsystoreply.gearbox.di.appModule
import de.comsystoreply.gearbox.di.networkModule
import de.comsystoreply.gearbox.di.repositoryModule
import de.comsystoreply.gearbox.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class GearboxApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        
        startKoin {
            androidContext(this@GearboxApp)
            modules(appModule, networkModule, repositoryModule, viewModelModule)
        }
        
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