package com.example.day02_ui_states

sealed class loginUiState{
    object Idel: loginUiState()
    object Loading: loginUiState()
    object Success: loginUiState()
    data class Error(val message:String): loginUiState()
}
