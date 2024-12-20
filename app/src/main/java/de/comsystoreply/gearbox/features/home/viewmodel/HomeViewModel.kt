package de.comsystoreply.gearbox.features.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.comsystoreply.gearbox.domain.models.TestResponse
import de.comsystoreply.gearbox.domain.services.ApiService
import kotlinx.coroutines.launch

class HomeViewModel(
    private val apiService: ApiService
) : ViewModel() {

    private val message: MutableState<TestResponse> = mutableStateOf(TestResponse())

    fun getMessage() =
        viewModelScope.launch {
            val response = apiService.getTestMessage()

            message.value = response
        }


}