package de.comsystoreply.gearbox.util

import android.content.Context
import de.comsystoreply.gearbox.BuildConfig
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.resource.GearboxString

object AppConfig {

    fun getBaseUrl(): String = EnvConfig.apiBaseUrl

    fun getEnvironmentName(): String = EnvConfig.environmentName

    fun isLoggingEnabled(): Boolean = EnvConfig.enableLogging

    /**
     * Check if debug mode is enabled
     */
    fun isDebugMode(context: Context): Boolean {
        return try {
            context.resources.getBoolean(R.bool.is_debug_mode)
        } catch (e: Exception) {
            BuildConfig.DEBUG
        }
    }

    /**
     * Get full API URL with endpoint
     */
    fun getApiUrl(endpoint: String): String {
        val baseUrl = getBaseUrl().removeSuffix("/")
        val cleanEndpoint = endpoint.removePrefix("/")
        return "$baseUrl/$cleanEndpoint"
    }

    /**
     * Get specific API endpoints
     */
    object Endpoints {
        fun auth(context: Context): String = context.getString(GearboxString.api_endpoint_auth)
        fun test(context: Context): String = context.getString(GearboxString.api_endpoint_test)
        fun users(context: Context): String = context.getString(GearboxString.api_endpoint_users)
        fun blogs(context: Context): String = context.getString(GearboxString.api_endpoint_blogs)
    }

    /**
     * Get error messages
     */
    object ErrorMessages {
        fun network(context: Context): String = context.getString(GearboxString.error_network)
        fun server(context: Context): String = context.getString(GearboxString.error_server)
        fun unauthorized(context: Context): String =
            context.getString(GearboxString.error_unauthorized)

        fun unknown(context: Context): String = context.getString(GearboxString.error_unknown)
        fun timeout(context: Context): String = context.getString(GearboxString.error_timeout)
    }
}