package de.comsystoreply.gearbox.features.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Patterns

class LoginViewModel : ViewModel() {
    
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
            
            try {
                // TODO: Replace with actual repository call
                // val result = authRepository.login(currentState.email, currentState.password)
                
                // Simulate network call
                kotlinx.coroutines.delay(1500)
                
                // Simulate success for demo
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Login failed. Please try again."
                )
            }
        }
    }
    
    private fun performGoogleLogin() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                // TODO: Implement Google Sign-In
                kotlinx.coroutines.delay(1000)
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Google sign-in failed. Please try again."
                )
            }
        }
    }
    
    private fun performAppleLogin() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                // TODO: Implement Apple Sign-In
                kotlinx.coroutines.delay(1000)
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Apple sign-in failed. Please try again."
                )
            }
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