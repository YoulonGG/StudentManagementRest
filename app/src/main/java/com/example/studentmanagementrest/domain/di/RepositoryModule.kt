package com.example.studentmanagementrest.domain.di

import com.example.studentmanagementrest.data.remote.repositoryImpl.AuthRepositoryImpl
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Module
@InstallIn(SingletonComponent::class)
interface
RepositoryModule {

    @Binds
    @Singleton
    fun bindAuthRepository(
        auth: AuthRepositoryImpl
    ): AuthRepository

}