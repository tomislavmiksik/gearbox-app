package de.comsystoreply.gearbox.util

import de.comsystoreply.gearbox.BuildConfig

object EnvConfig {
    val apiBaseUrl: String get() = BuildConfig.API_BASE_URL
    val environmentName: String get() = BuildConfig.ENVIRONMENT_NAME
    val enableLogging: Boolean get() = BuildConfig.LOGGING_ENABLED
}