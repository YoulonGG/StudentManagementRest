package com.example.studentmanagementrest.data.remote.intercepter

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("accept", "application/json")
            .header("Content-Type", "application/json")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
