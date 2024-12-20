package de.comsystoreply.gearbox.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.google.gson.Gson
import de.comsystoreply.gearbox.domain.services.ApiService
import de.comsystoreply.gearbox.features.home.viewmodel.HomeViewModel
import de.comsystoreply.gearbox.util.Constants.AUTH_PREFERENCES
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create(
            produceFile = {
                androidContext().preferencesDataStoreFile(AUTH_PREFERENCES)
            }
        )
    }
}

val networkModule = module {
    single<String>(qualifier = named("baseUrl")) {
        "http://10.0.2.2:8080/"
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(qualifier = named("baseUrl")))
            .addConverterFactory(
                GsonConverterFactory.create(
                    Gson().newBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}

val viewModelModule = module {
    factory { HomeViewModel(get()) }
}
