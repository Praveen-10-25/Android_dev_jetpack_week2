package com.example.dagger_hilt.di.data

import javax.inject.Inject


interface UserRepo{
    fun getUser():User
}
class DummyRepo @Inject constructor():UserRepo {
    override fun getUser(): User {
        return User(name="Arthur Morgan",email="Morgan@blackWaters.in",phone=7092636961)
    }
}