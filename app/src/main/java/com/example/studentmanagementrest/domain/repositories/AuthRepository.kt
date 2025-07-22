package com.example.studentmanagementrest.domain.repositories

import com.example.studentmanagementrest.data.dto.response.BaseMessageResponse


/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
interface AuthRepository {
    suspend fun signUpAdmin(request: HashMap<String, Any>): BaseMessageResponse
    suspend fun loginAdmin(request: HashMap<String, Any>): BaseMessageResponse
}