package de.comsystoreply.gearbox.domain.repository

import de.comsystoreply.gearbox.domain.models.AuthResult
import de.comsystoreply.gearbox.domain.models.AuthenticationRequest
import de.comsystoreply.gearbox.domain.models.RefreshTokenRequest

interface AuthRepository {
    suspend fun signIn(request: AuthenticationRequest): AuthResult
    suspend fun signUp(request: AuthenticationRequest): AuthResult
    suspend fun refreshToken(request: RefreshTokenRequest): AuthResult
    suspend fun logout()
    suspend fun getCurrentUser(): String?
    suspend fun isUserLoggedIn(): Boolean
}