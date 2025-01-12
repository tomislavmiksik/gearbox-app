package de.comsystoreply.gearbox.features.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Patterns
import de.comsystoreply.gearbox.domain.models.AuthResult
import de.comsystoreply.gearbox.domain.models.AuthenticationRequest
import de.comsystoreply.gearbox.domain.repository.AuthRepository

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    
    fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EmailChanged -> updateEmail(intent.email)
            is LoginIntent.PasswordChanged -> updatePassword(intent.password)
            is LoginIntent.LoginClicked -> performLogin()
            is LoginIntent.GoogleLoginClicked -> performGoogleLogin()
            is LoginIntent.AppleLoginClicked -> performAppleLogin()
            is LoginIntent.ErrorDismissed -> dismissError()
        }
    }
    
    private fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(
            email = email,
            isEmailValid = isValidEmail(email) || email.isEmpty()
        )
    }
    
    private fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(
            password = password,
            isPasswordValid = isValidPassword(password) || password.isEmpty()
        )
    }
    
    private fun performLogin() {
        val currentState = _uiState.value
        
        // Validate inputs
        val isEmailValid = isValidEmail(currentState.email)
        val isPasswordValid = isValidPassword(currentState.password)
        
        _uiState.value = currentState.copy(
            isEmailValid = isEmailValid,
            isPasswordValid = isPasswordValid
        )
        
        if (!isEmailValid || !isPasswordValid) {
            return
        }
        
        // Perform login
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            val request = AuthenticationRequest(
                email = currentState.email,
                password = currentState.password
            )
            
            when (val result = authRepository.signIn(request)) {
                is AuthResult.Success -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isLoginSuccessful = true
                    )
                }
                is AuthResult.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
                is AuthResult.NetworkError -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
    
    private fun performGoogleLogin() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            // TODO: Implement Google Sign-In with proper OAuth flow
            // For now, show a placeholder message
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                error = "Google Sign-In not implemented yet"
            )
        }
    }
    
    private fun performAppleLogin() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            // TODO: Implement Apple Sign-In with proper OAuth flow
            // For now, show a placeholder message
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                error = "Apple Sign-In not implemented yet"
            )
        }
    }
    
    private fun dismissError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    private fun isValidEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
    
    fun resetLoginSuccess() {
        _uiState.value = _uiState.value.copy(isLoginSuccessful = false)
    }
}