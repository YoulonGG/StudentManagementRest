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
import com.example.studentmanagementrest.core.ui_components.CommonButton
import com.example.studentmanagementrest.core.ui_components.CommonTextField
import com.example.studentmanagementrest.core.ui_components.dialogs.InfoDialog
import com.example.studentmanagementrest.core.ui_components.dialogs.SingleActionDialog

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {

    var txtFirstName by remember { mutableStateOf(TextFieldValue(uiState.firstName)) }
    var txtLastName by remember { mutableStateOf(TextFieldValue(uiState.lastName)) }
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
                    inputData = txtFirstName,
                    onValueChanged = { newTextFieldValue ->
                        txtFirstName = newTextFieldValue
                    },
                    hint = "First Name"
                )
                CommonTextField(
                    inputData = txtLastName,
                    onValueChanged = { newTextFieldValue ->
                        txtLastName = newTextFieldValue
                    },
                    hint = "Last Name"
                )
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
                    onButtonClick = {
                        onAction(
                            SignUpAction.SignUp(
                                txtFirstName.text,
                                txtLastName.text,
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
                        onAction(SignUpAction.ClearError)
                    }
                )
            }
            if (uiState.isError) {
                SingleActionDialog(
                    title = "Error",
                    description = "${uiState.errorMessage}",
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