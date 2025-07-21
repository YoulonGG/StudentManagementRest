package com.example.studentmanagementrest.presentation.auth.login

import com.example.studentmanagementrest.core.base.BaseViewModel
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */
class LoginViewModel @Inject constructor(

) : BaseViewModel<LoginUiState, LoginAction>() {

    override fun setInitialState(): LoginUiState = LoginUiState()

    override fun onAction(event: LoginAction) {
        when (event) {
            else -> {}
        }
    }
}