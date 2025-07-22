package com.example.studentmanagementrest.domain.useCase

import com.example.studentmanagementrest.data.dto.response.BaseMessageResponse
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.data.remote.util.toApiError
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

class SignUpUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke(hashMap: HashMap<String, Any>): Flow<ApiResult<BaseMessageResponse>> =
        flow {
            emit(ApiResult.Loading())
            try {
                val response = authRepository.signUpAdmin(hashMap)
                response.message.toApiResult(response).let { emit(it) }
            } catch (ex: Exception) {
                emit(ex.toApiError())
            }
        }
}