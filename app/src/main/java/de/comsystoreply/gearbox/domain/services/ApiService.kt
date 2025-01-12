package de.comsystoreply.gearbox.domain.services

import de.comsystoreply.gearbox.domain.models.AuthenticationRequest
import de.comsystoreply.gearbox.domain.models.AuthenticationResponse
import de.comsystoreply.gearbox.domain.models.RefreshTokenRequest
import de.comsystoreply.gearbox.domain.models.TestResponse
import de.comsystoreply.gearbox.util.Constants.AUTH_API
import de.comsystoreply.gearbox.util.Constants.TEST_API
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    // Test Call
    @GET("$TEST_API/message")
    suspend fun getTestMessage(): TestResponse

    // Authentication
    @POST("$AUTH_API/signIn")
    suspend fun signIn(@Body request: AuthenticationRequest): AuthenticationResponse

    @POST("$AUTH_API/signUp")
    suspend fun signUp(@Body request: AuthenticationRequest): AuthenticationResponse

    @POST("$AUTH_API/refreshToken")
    suspend fun refreshToken(@Body request: RefreshTokenRequest): AuthenticationResponse
}