package de.comsystoreply.gearbox.domain.models

data class AuthenticationRequest(
    val email: String,
    val username: String? = null,
    val password: String,
    val confirmPassword: String? = null
)

data class AuthenticationResponse(
    val token: String,
    val refreshToken: String,
    val id: String,
    val email: String,
    val username: String,
    val profileImageUrl: String?
)

data class RefreshTokenRequest(
    val refreshToken: String
)

sealed class AuthResult {
    data class Success(val response: AuthenticationResponse) : AuthResult()
    data class Error(val message: String) : AuthResult()
    data class NetworkError(val message: String) : AuthResult()
}

sealed class AuthException(message: String) : Exception(message) {
    class InvalidCredentials(message: String = "Invalid email or password") : AuthException(message)
    class UserAlreadyExists(message: String = "User already exists") : AuthException(message)
    class NetworkError(message: String = "Network error occurred") : AuthException(message)
    class UnknownError(message: String = "An unknown error occurred") : AuthException(message)
}