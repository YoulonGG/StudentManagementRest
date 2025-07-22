package com.example.studentmanagementrest.presentation.auth.signup.signup_name

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */
@Composable
fun SignUpNameRoute(
    navController: NavHostController
) {
    val viewModel: SignUpNameViewModel = hiltViewModel()
    SignUpNameScreen(
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction,
        onNavigate = navController
    )
}


data class SignUpNameUiState(
    val isLoading: Boolean = false,
    val firstName: String = "",
    val lastName: String = "",
)


sealed class SignUpNameAction {
    data object Next : SignUpNameAction()
}