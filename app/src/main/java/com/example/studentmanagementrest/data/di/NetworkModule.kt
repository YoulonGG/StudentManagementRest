package com.example.studentmanagementrest.data.di

import com.example.studentmanagementrest.data.remote.intercepter.ErrorHandlingInterceptor
import com.example.studentmanagementrest.data.remote.intercepter.HeaderInterceptor
import com.example.studentmanagementrest.data.remote.util.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {


    @Provides
    @Singleton
    fun provideLoggingInterceptor(
    ): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://zeaustin.pythonanywhere.com/")
            .client(
                OkHttpClient.Builder().apply {
                    writeTimeout(60, TimeUnit.SECONDS)
                    readTimeout(60, TimeUnit.SECONDS)
                    connectTimeout(60, TimeUnit.SECONDS)
                    addInterceptor(HeaderInterceptor())
                    addInterceptor(HttpLoggingInterceptor())
                    addInterceptor(ErrorHandlingInterceptor())
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
