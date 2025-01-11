package de.comsystoreply.gearbox.features.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.comsystoreply.gearbox.domain.models.TestResponse
import de.comsystoreply.gearbox.domain.services.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeUiState(
    val isLoading: Boolean = false,
    val message: TestResponse? = null,
    val error: String? = null
)

sealed interface HomeIntent {
    object LoadMessage : HomeIntent
    object RetryClicked : HomeIntent
    object ErrorDismissed : HomeIntent
}

class HomeViewModel(
    private val apiService: ApiService
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.LoadMessage -> loadMessage()
            is HomeIntent.RetryClicked -> loadMessage()
            is HomeIntent.ErrorDismissed -> dismissError()
        }
    }

    private fun loadMessage() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                val response = apiService.getTestMessage()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    message = response
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load message"
                )
            }
        }
    }

    private fun dismissError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}