package com.example.dagger_hilt.di

import com.example.dagger_hilt.di.data.DummyRepo
import com.example.dagger_hilt.di.data.UserRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindUserRepo(
        dummyrepo: DummyRepo
    ): UserRepo
}