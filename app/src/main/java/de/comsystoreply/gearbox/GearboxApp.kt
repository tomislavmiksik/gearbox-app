package de.comsystoreply.gearbox

import android.app.Application
import de.comsystoreply.gearbox.di.appModule
import de.comsystoreply.gearbox.di.networkModule
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
            modules(appModule, networkModule, viewModelModule)
        }
    }
}