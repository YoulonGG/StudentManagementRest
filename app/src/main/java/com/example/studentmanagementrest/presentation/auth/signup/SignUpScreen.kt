package com.example.studentmanagementrest.presentation.auth.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.core.ui_components.CommonButton
import com.example.studentmanagementrest.core.ui_components.CommonTextField
import com.example.studentmanagementrest.core.ui_components.dialogs.SingleActionDialog

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onNavigate: NavHostController,
    onAction: (SignUpAction) -> Unit
) {


    var txtEmail by remember { mutableStateOf(TextFieldValue(uiState.email)) }
    var txtPassword by remember { mutableStateOf(TextFieldValue(uiState.password)) }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                CommonTextField(
                    inputData = txtEmail,
                    onValueChanged = { newTextFieldValue ->
                        txtEmail = newTextFieldValue
                    },
                    hint = "Email"
                )
                CommonTextField(
                    inputData = txtPassword,
                    onValueChanged = { newTextFieldValue ->
                        txtPassword = newTextFieldValue
                    },
                    hint = "Password",
                )
                CommonButton(
                    modifier = Modifier.padding(top = 20.dp),
                    isEnabled = txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty(),
                    onButtonClick = {
                        onAction(
                            SignUpAction.SignUp(
                                txtEmail.text,
                                txtPassword.text
                            )
                        )
                    },
                    text = "Sign Up",
                )
            }
            if (uiState.isSuccess) {
                SingleActionDialog(
                    title = "Success",
                    description = "${uiState.successMessage}",
                    onDismiss = {
                        onNavigate.navigate(ScreenRoute.LoginScreen)
                    }
                )
            }
            if (uiState.isError) {
                SingleActionDialog(
                    title = "Error",
                    description = uiState.errorMessage,
                    onDismiss = {
                        onAction(SignUpAction.ClearError)
                    }
                )
            }
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        CircularProgressIndicator()
                    }
                )
            }
        }
    )
}