package com.example.studentmanagementrest.presentation.auth.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.studentmanagementrest.core.base.BaseViewModel
import com.example.studentmanagementrest.core.events.NotifyEvents
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.core.provider.UserManager
import com.example.studentmanagementrest.data.dto.request.LoginRequest
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.domain.useCase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState, LoginAction>() {

    override fun setInitialState(): LoginUiState = LoginUiState()

    override fun onAction(event: LoginAction) {
        when (event) {
            is LoginAction.Login -> {
                login(event.email, event.password)
            }
        }
    }

    private fun login(email: String, password: String) {
        val request = LoginRequest(
            email = email, password = password
        )
        loginUseCase.invoke(request).flowOn(Dispatchers.IO).onEach { result ->
            when (result) {
                is ApiResult.Error -> {
                    handleToastError(result.error)
                }

                is ApiResult.Loading -> {
                    sendEvent(NotifyEvents.ToggleLoading(true))
                }

                is ApiResult.Success -> {
                    sendEvent(NotifyEvents.Navigate(ScreenRoute.BottomNav))
                    UserManager.saveToken(
                        result.data?.accessToken ?: result.data?.refreshToken ?: ""
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}