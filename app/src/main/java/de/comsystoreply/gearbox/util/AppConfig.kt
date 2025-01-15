package de.comsystoreply.gearbox.util

import android.content.Context
import de.comsystoreply.gearbox.BuildConfig
import de.comsystoreply.gearbox.R

object AppConfig {
    
    /**
     * Get the base URL for API calls
     * Priority: Environment Variables > String Resources > Fallback
     */
    fun getBaseUrl(context: Context): String {
        return try {
            val flavor = getCurrentFlavor()
            EnvConfig.getBaseUrlForFlavor(flavor)
        } catch (e: Exception) {
            try {
                context.getString(R.string.api_base_url)
            } catch (e: Exception) {
                "http://10.0.2.2:8080" // Fallback for development
            }
        }
    }
    
    /**
     * Get API version from environment variables
     */
    fun getApiVersion(): String {
        return try {
            EnvConfig.apiVersion
        } catch (e: Exception) {
            "v1" // Default fallback
        }
    }
    
    /**
     * Check if logging is enabled
     */
    fun isLoggingEnabled(context: Context): Boolean {
        return try {
            val flavor = getCurrentFlavor()
            EnvConfig.getLoggingEnabledForFlavor(flavor)
        } catch (e: Exception) {
            try {
                context.resources.getBoolean(R.bool.enable_logging)
            } catch (e: Exception) {
                BuildConfig.DEBUG // Fallback to debug mode
            }
        }
    }
    
    /**
     * Get environment name
     */
    fun getEnvironment(context: Context): String {
        return try {
            val flavor = getCurrentFlavor()
            EnvConfig.getEnvironmentNameForFlavor(flavor)
        } catch (e: Exception) {
            try {
                context.getString(R.string.environment_name)
            } catch (e: Exception) {
                "development" // Fallback
            }
        }
    }
    
    /**
     * Get the current build flavor
     */
    private fun getCurrentFlavor(): String {
        return try {
            BuildConfig.FLAVOR
        } catch (e: Exception) {
            "development" // Default fallback
        }
    }
    
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
    fun getApiUrl(context: Context, endpoint: String): String {
        val baseUrl = getBaseUrl(context).removeSuffix("/")
        val cleanEndpoint = endpoint.removePrefix("/")
        return "$baseUrl/$cleanEndpoint"
    }
    
    /**
     * Get specific API endpoints
     */
    object Endpoints {
        fun auth(context: Context): String = context.getString(R.string.api_endpoint_auth)
        fun test(context: Context): String = context.getString(R.string.api_endpoint_test)
        fun users(context: Context): String = context.getString(R.string.api_endpoint_users)
        fun blogs(context: Context): String = context.getString(R.string.api_endpoint_blogs)
    }
    
    /**
     * Get error messages
     */
    object ErrorMessages {
        fun network(context: Context): String = context.getString(R.string.error_network)
        fun server(context: Context): String = context.getString(R.string.error_server)
        fun unauthorized(context: Context): String = context.getString(R.string.error_unauthorized)
        fun unknown(context: Context): String = context.getString(R.string.error_unknown)
        fun timeout(context: Context): String = context.getString(R.string.error_timeout)
    }
}