package com.example.studentmanagementrest.presentation.auth.signup

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.io.Serializable

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SignUpRoute() {

    val viewModel: SignUpViewModel = hiltViewModel()

    SignUpScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}

data class SignUpUiState(
    val isLoading: Boolean = false,
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val email: String = "",
    val errorMessage: String = "",
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val successMessage: String? = null
)


sealed interface SignUpAction {
    data class SignUp(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
    ) : SignUpAction

    data object ClearError : SignUpAction
}
