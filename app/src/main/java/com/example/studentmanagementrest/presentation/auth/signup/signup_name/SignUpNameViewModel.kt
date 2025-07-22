package com.example.studentmanagementrest.presentation.auth.signup.signup_name

import com.example.studentmanagementrest.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */


@HiltViewModel
class SignUpNameViewModel @Inject constructor() : BaseViewModel<SignUpNameUiState, SignUpNameAction>() {
    override fun setInitialState(): SignUpNameUiState = SignUpNameUiState()

    override fun onAction(event: SignUpNameAction) {
        when (event) {
            SignUpNameAction.Next -> {}
        }
    }
}