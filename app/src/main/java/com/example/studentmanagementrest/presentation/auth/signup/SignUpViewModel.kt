package com.example.studentmanagementrest.presentation.auth.signup

import androidx.lifecycle.viewModelScope
import com.example.studentmanagementrest.core.base.BaseViewModel
import com.example.studentmanagementrest.core.events.NotifyEvents
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.domain.useCase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : BaseViewModel<SignUpUiState, SignUpAction>() {

    override fun setInitialState(): SignUpUiState = SignUpUiState()

    override fun onAction(event: SignUpAction) {
        when (event) {
            is SignUpAction.SignUp -> {
                signupAdmin(
                    firstName = event.firstName,
                    lastName = event.lastName,
                    email = event.email,
                    password = event.password
                )
            }

            SignUpAction.ClearError -> {
                setState {
                    copy(
                        isError = false,
                        errorMessage = "",
                        isSuccess = false,
                        successMessage = null
                    )
                }
            }
        }
    }

    private fun signupAdmin(firstName: String, lastName: String, email: String, password: String) {
        val map = HashMap<String, Any>()
        map["first_name"] = firstName
        map["last_name"] = lastName
        map["email"] = email
        map["password"] = password

        signUpUseCase.invoke(map)
            .flowOn(Dispatchers.IO)
            .onEach { result ->
                when (result) {
                    is ApiResult.Error -> {
                        setState {
                            copy(
                                isLoading = false,
                                isError = true,
                                isSuccess = false,
                                successMessage = null,
                                errorMessage = result.error?.message ?: ""
                            )
                        }
                    }

                    is ApiResult.Loading -> {
                        setState { copy(isLoading = true, isError = false, isSuccess = false) }
                    }

                    is ApiResult.Success -> {
                        setState {
                            copy(
                                isLoading = false,
                                isError = false,
                                isSuccess = true,
                                successMessage = result.data ?: "Sign up successful!",
                            )
                        }
                        sendEvent(NotifyEvents.Navigate(ScreenRoute.LoginScreen))
                    }
                }
            }.launchIn(viewModelScope)
    }
}







