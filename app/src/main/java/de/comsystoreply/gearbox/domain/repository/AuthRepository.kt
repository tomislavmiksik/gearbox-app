package de.comsystoreply.gearbox.domain.repository

import de.comsystoreply.gearbox.domain.models.AuthResult
import de.comsystoreply.gearbox.domain.models.AuthenticationRequest

interface AuthRepository {
    suspend fun signIn(request: AuthenticationRequest): AuthResult
    suspend fun signUp(request: AuthenticationRequest): AuthResult
    suspend fun logout()
    suspend fun isUserLoggedIn(): Boolean
}