package com.example.studentmanagementrest.presentation.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SignUpRoute() {

    val viewModel: SignUpViewModel = hiltViewModel()

    SignUpScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    )
}

data class SignUpUiState(
    val isLoading: Boolean = true,
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val email: String = ""
)


sealed interface SignUpAction {
    data class SignUp(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
    ) : SignUpAction
}
