package com.example.dagger_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger_hilt.di.data.User
import com.example.dagger_hilt.di.data.UserRepo
import com.example.dagger_hilt.di.data.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModel@Inject constructor(private val repo:UserRepo):ViewModel(){
    private val _userState= MutableLiveData<UserState>()
    val userState:LiveData<UserState> = _userState

    init {
        loadUser()
    }

    private fun loadUser(){
        _userState.value=UserState.Loading
        try{
            val user=repo.getUser()
            _userState.value=UserState.Success(user)
        }
        catch (e:Exception){
            _userState.value=UserState.Error("Failed To Load")
        }
    }
}