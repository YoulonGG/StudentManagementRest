package com.example.studentmanagementrest.presentation.auth.signup.signup_name

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SignUpNameScreen(
    uiState: SignUpNameUiState,
    onNavigate: NavHostController,
    onAction: (SignUpNameAction) -> Unit
) {

    var txtFirstName by remember { mutableStateOf(TextFieldValue(uiState.firstName)) }
    var txtLastName by remember { mutableStateOf(TextFieldValue(uiState.lastName)) }

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
                CommonButton(
                    modifier = Modifier.padding(top = 20.dp),
                    onButtonClick = {
                        onNavigate.navigate(
                            ScreenRoute.SignScreen(
                                txtFirstName.text,
                                txtLastName.text
                            )
                        )
                    },
                    isEnabled = txtLastName.text.isNotEmpty() && txtFirstName.text.isNotEmpty(),
                    text = "Submit",
                )
            }
        }
    )
}

