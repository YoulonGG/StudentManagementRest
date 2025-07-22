package com.example.studentmanagementrest.domain.useCase

import com.example.studentmanagementrest.data.dto.response.BaseMessageResponse
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(hashMap: HashMap<String, Any>): Flow<ApiResult<BaseMessageResponse>> =
        flow {
            emit(ApiResult.Loading())
            try {
                val request = repository.loginAdmin(hashMap)
                emit(ApiResult.Success(request))
            } catch (e: Exception) {

                emit(ApiResult.Error(e))
            }
        }
}