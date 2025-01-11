package de.comsystoreply.gearbox.features.login.ui.viewmodel

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isEmailValid: Boolean = true,
    val isPasswordValid: Boolean = true,
    val error: String? = null,
    val isLoginSuccessful: Boolean = false
)

sealed interface LoginIntent {
    data class EmailChanged(val email: String) : LoginIntent
    data class PasswordChanged(val password: String) : LoginIntent
    object LoginClicked : LoginIntent
    object GoogleLoginClicked : LoginIntent
    object AppleLoginClicked : LoginIntent
    object ErrorDismissed : LoginIntent
}