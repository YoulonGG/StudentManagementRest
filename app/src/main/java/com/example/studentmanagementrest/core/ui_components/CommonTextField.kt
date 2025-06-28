package com.example.studentmanagementrest.core.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

/**
 * @Author: John Youlong.
 * @Date: 6/28/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun CommonTextField(
    text: TextFieldValue,
    onChangeValueText: (TextFieldValue) -> Unit,
    hint: String = "",
    isPassword: Boolean = false,

    ) {

    val passwordVisible by remember { mutableStateOf(false) }
    val visualTransformation =
        if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None

    OutlinedTextField(
        value = text,
        onValueChange = { newTextFieldValue ->
            onChangeValueText.invoke(newTextFieldValue)
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
        ),
        visualTransformation = visualTransformation,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    )

}