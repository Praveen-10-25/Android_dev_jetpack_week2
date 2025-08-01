package com.example.statehoisting.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel: ViewModel() {

    private val _name=MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email=MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password=MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmpass=MutableLiveData<String>()
    val confirmpass: LiveData<String> = _confirmpass

    fun onUpdatename(newname:String){
        _name.value=newname.trim()
    }
    fun onUpdateEmail(newEmail:String){
            _email.value = newEmail.trim()
    }
    fun onUpdatepass(newpass:String){
        _password.value=newpass.trim()
    }
    fun onConfirmPass(confirmpassword:String){
        _confirmpass.value=confirmpassword.trim()
    }
}