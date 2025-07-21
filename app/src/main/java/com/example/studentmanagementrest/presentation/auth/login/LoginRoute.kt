package com.example.studentmanagementrest.presentation.auth.login

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun LoginRoute() {

    val viewModel: LoginViewModel = hiltViewModel()

    LoginScreen()
}


data class LoginUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)


sealed interface LoginAction {}