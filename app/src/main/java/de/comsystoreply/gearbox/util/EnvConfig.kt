package de.comsystoreply.gearbox.util

import io.github.cdimascio.dotenv.dotenv

object EnvConfig {
    
    private val dotenv = dotenv {
        directory = "/assets"
        filename = "env"
        ignoreIfMalformed = true
        ignoreIfMissing = true
    }
    
    // Development Environment
    val devApiBaseUrl: String get() = dotenv["DEV_API_BASE_URL"] ?: "http://10.0.2.2:8080"
    val devEnvironmentName: String get() = dotenv["DEV_ENVIRONMENT_NAME"] ?: "Development"
    
    // Staging Environment
    val stagingApiBaseUrl: String get() = dotenv["STAGING_API_BASE_URL"] ?: "https://staging-api.gearbox.com"
    val stagingEnvironmentName: String get() = dotenv["STAGING_ENVIRONMENT_NAME"] ?: "Staging"
    
    // Production Environment
    val prodApiBaseUrl: String get() = dotenv["PROD_API_BASE_URL"] ?: "https://api.gearbox.com"
    val prodEnvironmentName: String get() = dotenv["PROD_ENVIRONMENT_NAME"] ?: "Production"
    
    // Common Configuration
    val apiVersion: String get() = dotenv["API_VERSION"] ?: "v1"
    val enableLoggingDev: Boolean get() = dotenv["ENABLE_LOGGING_DEV"]?.toBoolean() ?: true
    val enableLoggingStaging: Boolean get() = dotenv["ENABLE_LOGGING_STAGING"]?.toBoolean() ?: true
    val enableLoggingProd: Boolean get() = dotenv["ENABLE_LOGGING_PROD"]?.toBoolean() ?: false
    
    /**
     * Get the appropriate base URL for the current build variant
     */
    fun getBaseUrlForFlavor(flavor: String): String {
        return when (flavor.lowercase()) {
            "development" -> devApiBaseUrl
            "staging" -> stagingApiBaseUrl
            "production" -> prodApiBaseUrl
            else -> devApiBaseUrl // Default fallback
        }
    }
    
    /**
     * Get the appropriate environment name for the current build variant
     */
    fun getEnvironmentNameForFlavor(flavor: String): String {
        return when (flavor.lowercase()) {
            "development" -> devEnvironmentName
            "staging" -> stagingEnvironmentName
            "production" -> prodEnvironmentName
            else -> devEnvironmentName // Default fallback
        }
    }
    
    /**
     * Get logging enabled status for the current build variant
     */
    fun getLoggingEnabledForFlavor(flavor: String): Boolean {
        return when (flavor.lowercase()) {
            "development" -> enableLoggingDev
            "staging" -> enableLoggingStaging
            "production" -> enableLoggingProd
            else -> true // Default fallback
        }
    }
}