package com.example.studentmanagementrest.data.remote.repositoryImpl

import com.example.studentmanagementrest.data.remote.util.ApiService
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    AuthRepository {

    override suspend fun signUpAdmin(request: HashMap<String, Any>) {
        return apiService.signupAdmin(request)
    }

}