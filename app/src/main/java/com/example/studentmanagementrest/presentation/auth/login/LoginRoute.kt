package com.example.studentmanagementrest.presentation.auth.login

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.studentmanagementrest.core.base.BaseScreen

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun LoginRoute(
    navController: NavHostController
) {
    val viewModel: LoginViewModel = hiltViewModel()
    BaseScreen(
        notifyEventsChannel = viewModel.notifyEventsChannel,
    ) {
        LoginScreen(
            uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
            onAction = viewModel::onAction,
            onNavigate = navController
        )
    }

}

data class LoginUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val isError: Boolean = false,
    val errorMessage: String = "",
    val isSuccess: Boolean = false,
    val successMessage: String = ""
)

sealed interface LoginAction {
    data class Login(
        val email: String,
        val password: String
    ) : LoginAction
}