package com.example.korochecats.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.korochecats.data.repository.CatsRepository
import kotlinx.coroutines.launch

class CatsViewModel(
    private val repository: CatsRepository
) : ViewModel() {
    var uiState by mutableStateOf(CatsUiState())
        private set

    fun getCatsImageList() {
        viewModelScope.launch {
            try {
                val response = repository.getCatsImageList()
                uiState = uiState.copy(catImageList = response)
            }
            catch (e: Exception) {
                println(e)
            }
        }
    }
}

class CatsViewModelFactory(
    private val repository: CatsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CatsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
