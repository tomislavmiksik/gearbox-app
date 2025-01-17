package de.comsystoreply.gearbox.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import de.comsystoreply.gearbox.domain.models.AuthResult
import de.comsystoreply.gearbox.domain.models.AuthenticationRequest
import de.comsystoreply.gearbox.domain.repository.AuthRepository
import de.comsystoreply.gearbox.domain.services.ApiService
import de.comsystoreply.gearbox.util.AppConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val dataStore: DataStore<Preferences>,
    private val context: Context,
) : AuthRepository {

    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    override suspend fun signIn(request: AuthenticationRequest): AuthResult {
        return try {
            val response = apiService.signIn(request)
            dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN_KEY] = response.token
                preferences[REFRESH_TOKEN_KEY] = response.refreshToken
            }

            AuthResult.Success(response)
        } catch (e: HttpException) {
            when (e.code()) {
                //TODO: rethink context in repo, bad practice :'
                401 -> AuthResult.Error(AppConfig.ErrorMessages.unauthorized(context))
                400 -> AuthResult.Error("Invalid request format")
                500 -> AuthResult.Error(AppConfig.ErrorMessages.server(context))
                else -> AuthResult.Error("Authentication failed: ${e.message()}")
            }
        } catch (e: SocketTimeoutException) {
            AuthResult.NetworkError(AppConfig.ErrorMessages.timeout(context))
        } catch (e: IOException) {
            AuthResult.NetworkError(AppConfig.ErrorMessages.network(context))
        } catch (e: Exception) {
            AuthResult.Error(AppConfig.ErrorMessages.unknown(context))
        }
    }

    override suspend fun signUp(request: AuthenticationRequest): AuthResult {
        return try {
            val response = apiService.signUp(request)
            dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN_KEY] = response.token
                preferences[REFRESH_TOKEN_KEY] = response.refreshToken
            }

            AuthResult.Success(response)
        } catch (e: HttpException) {
            when (e.code()) {
                409 -> AuthResult.Error("User already exists")
                400 -> AuthResult.Error("Invalid registration data")
                500 -> AuthResult.Error(AppConfig.ErrorMessages.server(context))
                else -> AuthResult.Error("Registration failed: ${e.message()}")
            }
        } catch (e: SocketTimeoutException) {
            AuthResult.NetworkError(AppConfig.ErrorMessages.timeout(context))
        } catch (e: IOException) {
            AuthResult.NetworkError(AppConfig.ErrorMessages.network(context))
        } catch (e: Exception) {
            AuthResult.Error(AppConfig.ErrorMessages.unknown(context))
        }
    }

    override suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    override suspend fun isUserLoggedIn(): Boolean {
        return dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN_KEY] != null
        }.first()
    }
}