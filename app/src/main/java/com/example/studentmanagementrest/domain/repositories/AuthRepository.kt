package com.example.studentmanagementrest.domain.repositories

import com.example.studentmanagementrest.data.dto.request.LoginRequest
import com.example.studentmanagementrest.data.dto.response.BaseMessageResponse
import com.example.studentmanagementrest.data.dto.response.LoginResponse


/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
interface AuthRepository {
    suspend fun signUpAdmin(request: HashMap<String, Any>): BaseMessageResponse
    suspend fun loginAdmin(request: LoginRequest): LoginResponse
}