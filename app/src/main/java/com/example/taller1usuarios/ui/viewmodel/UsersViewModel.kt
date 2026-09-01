package com.example.taller1usuarios.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taller1usuarios.data.model.User
import com.example.taller1usuarios.data.repository.UsersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface UsersUiState {
    data object Loading : UsersUiState
    data class Success(val users: List<User>) : UsersUiState
    data class Error(val message: String) : UsersUiState
}

class UsersViewModel(
    private val repository: UsersRepository = UsersRepository.Default,
) : ViewModel() {
    private val _uiState = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val uiState: StateFlow<UsersUiState> = _uiState.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            repository.getUsers().fold(
                onSuccess = { users -> _uiState.value = UsersUiState.Success(users) },
                onFailure = { error ->
                    _uiState.value = UsersUiState.Error(
                        error.message ?: "No fue posible cargar los usuarios.",
                    )
                },
            )
        }
    }
}
