package com.example.studentmanagementrest.presentation.auth.signup

import androidx.compose.foundation.layout.Arrangement
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
import com.example.studentmanagementrest.core.ui_components.CommonTextField

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun SignUpScreen(
    uiState: SignUpUiState
) {

    var txtFirstName by remember { mutableStateOf(TextFieldValue(uiState.firstName)) }
    var txtLastName by remember { mutableStateOf(TextFieldValue(uiState.lastName)) }
    var txtEmail by remember { mutableStateOf(TextFieldValue(uiState.email)) }
    var txtPassword by remember { mutableStateOf(TextFieldValue(uiState.password)) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        CommonTextField(
            text = txtFirstName,
            onChangeValueText = { newTextFieldValue ->
                txtFirstName = newTextFieldValue
            }
        )

        CommonTextField(
            text = txtLastName,
            onChangeValueText = { newTextFieldValue ->
                txtLastName = newTextFieldValue
            }
        )

        CommonTextField(
            text = txtEmail,
            onChangeValueText = { newTextFieldValue ->
                txtEmail = newTextFieldValue
            }
        )

        CommonTextField(
            text = txtPassword,
            onChangeValueText = { newTextFieldValue ->
                txtPassword = newTextFieldValue
            }
        )
    }

}