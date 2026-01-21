package com.example.firebase_ai.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebase_ai.data.AIGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val aiGenerator = AIGenerator()

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Initial)
    val uiState = _uiState.asStateFlow()

    fun generateText(text: String) {
        viewModelScope.launch {
            _uiState.update { MainUiState.Loading }
            val result = aiGenerator.generateText(text)
            result.fold(
                onSuccess = { data ->
                    _uiState.update { MainUiState.Success(data) }
                },
                onFailure = { throwable ->
                    _uiState.update { MainUiState.Error(throwable.message.orEmpty()) }
                })
        }

    }

}

sealed class MainUiState {
    data object Initial : MainUiState()
    data object Loading : MainUiState()
    data class Error(val error: String) : MainUiState()
    data class Success(val text: String) : MainUiState()
}