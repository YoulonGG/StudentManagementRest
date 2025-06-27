package com.example.studentmanagementrest.domain.repositories

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
interface AuthRepository {
    suspend fun signUpAdmin(request: HashMap<String, Any>)
}