package com.example.studentmanagementrest.presentation.auth.signup

import androidx.compose.runtime.Composable

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SignUpRoute() {
    SignUpScreen()
}

data class SignUpUiState(
    val isLoading: Boolean = true
)


sealed interface SignUpAction {
    data class SignUp(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
    ) : SignUpAction
}
