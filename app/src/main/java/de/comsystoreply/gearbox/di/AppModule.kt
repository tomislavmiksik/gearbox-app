package de.comsystoreply.gearbox.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.google.gson.Gson
import de.comsystoreply.gearbox.domain.services.ApiService
import de.comsystoreply.gearbox.data.repository.AuthRepositoryImpl
import de.comsystoreply.gearbox.domain.repository.AuthRepository
import de.comsystoreply.gearbox.features.home.ui.viewmodel.HomeViewModel
import de.comsystoreply.gearbox.features.login.ui.viewmodel.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
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
        de.comsystoreply.gearbox.util.AppConfig.getBaseUrl(androidContext())
    }
    
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = if (de.comsystoreply.gearbox.util.AppConfig.isLoggingEnabled(androidContext())) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(qualifier = named("baseUrl")))
            .client(get<OkHttpClient>())
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

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get(), androidContext()) }
}

val viewModelModule = module {
    factory { HomeViewModel(get()) }
    factory { LoginViewModel(get()) }
}
