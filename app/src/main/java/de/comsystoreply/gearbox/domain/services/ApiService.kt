package de.comsystoreply.gearbox.domain.services

import de.comsystoreply.gearbox.domain.models.TestResponse
import de.comsystoreply.gearbox.util.Constants.AUTH_API
import de.comsystoreply.gearbox.util.Constants.TEST_API
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    // Test Call
    @GET("$TEST_API/message")
    suspend fun getTestMessage(): TestResponse

    // Auth
    @POST("$AUTH_API/signIn")
    suspend fun login(): TestResponse

    @POST("$AUTH_API/signUp")
    suspend fun signUp(): TestResponse

    @POST("$AUTH_API/refreshToken")
    suspend fun refreshToken(): TestResponse
}