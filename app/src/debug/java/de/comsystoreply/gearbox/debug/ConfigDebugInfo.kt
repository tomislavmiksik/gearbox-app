package de.comsystoreply.gearbox.debug

import android.content.Context
import de.comsystoreply.gearbox.BuildConfig
import de.comsystoreply.gearbox.util.AppConfig
import timber.log.Timber

object ConfigDebugInfo {

    fun logConfigInfo(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.d("=== App Configuration Debug Info ===")
            Timber.d("Base URL: ${AppConfig.getBaseUrl()}")
            Timber.d("API Version: ${AppConfig.getApiVersion()}")
            Timber.d("Logging Enabled: ${AppConfig.isLoggingEnabled()}")
            Timber.d("Debug Mode: ${AppConfig.isDebugMode(context)}")
            Timber.d("Build Type: ${BuildConfig.BUILD_TYPE}")
            Timber.d("Application ID: ${BuildConfig.APPLICATION_ID}")
            Timber.d("Version Name: ${BuildConfig.VERSION_NAME}")

            // Test API endpoints
            Timber.d("Auth Endpoint: ${AppConfig.Endpoints.auth(context)}")
            Timber.d("Test Endpoint: ${AppConfig.Endpoints.test(context)}")

            // Test full API URLs
            Timber.d(
                "Full Auth URL: ${
                    AppConfig.getApiUrl(
                        AppConfig.Endpoints.auth(context)
                    )
                }"
            )
            Timber.d("=====================================")
        }
    }

    fun getConfigSummary(context: Context): String {
        return buildString {
            appendLine("Configuration Summary:")
            appendLine("Base URL: ${AppConfig.getBaseUrl()}")
            appendLine("Debug Mode: ${AppConfig.isDebugMode(context)}")
            appendLine("Logging: ${AppConfig.isLoggingEnabled()}")
            appendLine("Build Type: ${BuildConfig.BUILD_TYPE}")
        }
    }
}