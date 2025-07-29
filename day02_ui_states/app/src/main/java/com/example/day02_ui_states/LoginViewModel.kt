package com.example.day02_ui_states

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel :ViewModel(){
    private val _loginstate=MutableStateFlow<loginUiState>(loginUiState.Idel)
    val loginstate:StateFlow<loginUiState> = _loginstate

    fun login(username:String,password:String){
        _loginstate.value=loginUiState.Loading
        viewModelScope.launch {
            delay(3000)
            if(username=="phantom"&& password=="5028"){
                _loginstate.value=loginUiState.Success
            }else{
                _loginstate.value=loginUiState.Error("Invalid Credentials")
            }
        }
    }
}