package com.example.studentmanagementrest.domain.useCase

import com.example.studentmanagementrest.data.dto.request.LoginRequest
import com.example.studentmanagementrest.data.dto.response.LoginResponse
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.data.remote.util.toApiResult
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke(requestData: LoginRequest): Flow<ApiResult<LoginResponse>> =
        flow {
            emit(ApiResult.Loading())
            try {
                val response = authRepository.loginAdmin(requestData)
                emit(ApiResult.Success(response))
            } catch (e: Exception) {
                emit(ApiResult.Error(e))
            }
        }
}