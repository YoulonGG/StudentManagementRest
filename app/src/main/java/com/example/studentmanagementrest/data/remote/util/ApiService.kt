package com.example.studentmanagementrest.data.remote.util

import com.example.studentmanagementrest.data.remote.common.ApiConstant
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
interface ApiService {

    @POST(ApiConstant.REGISTER_ADMIN)
    suspend fun signupAdmin(@Body params: HashMap<String, Any>)

}