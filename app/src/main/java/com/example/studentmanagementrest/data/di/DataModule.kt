package com.example.studentmanagementrest.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.studentmanagementrest.data.local.StudentManagementAppPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideEncryptedSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(StudentManagementAppPreference.PREFS_NAME, Context.MODE_PRIVATE)
    }

}