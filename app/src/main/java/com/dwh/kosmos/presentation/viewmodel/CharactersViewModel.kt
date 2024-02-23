package com.dwh.kosmos.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwh.kosmos.domain.model.ApiResModel
import com.dwh.kosmos.domain.uses_cases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private var _uiState: MutableStateFlow<UIState<ApiResModel?>> = MutableStateFlow(UIState.Loading)
    val uiState: MutableStateFlow<UIState<ApiResModel?>> get() = _uiState
    
    fun getCharacters() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.value = UIState.Loading
        try {
            getCharactersUseCase().collect {
                _uiState.value = UIState.Success(it)
            }
        } catch (e: Exception) {
            _uiState.value = UIState.Error(e.message ?: "Error desconocido")
        }
    }
}