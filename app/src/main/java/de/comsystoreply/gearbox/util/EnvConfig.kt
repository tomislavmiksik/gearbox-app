package de.comsystoreply.gearbox.util

object EnvConfig {
    val apiBaseUrl get(): String = "http://10.0.2.2:8080"
    val apiVersion get(): String = "Development"
    val enableLogging get() : Boolean = true
}