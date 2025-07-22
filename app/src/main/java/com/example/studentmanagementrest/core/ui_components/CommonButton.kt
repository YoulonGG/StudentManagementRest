package com.example.studentmanagementrest.core.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementrest.core.resource.buttonDisableColor
import com.example.studentmanagementrest.core.resource.lightBlueColor

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    gradient: Brush? = null,
    isEnabled: Boolean = true,
    onButtonClick: () -> Unit
) {

    val gradientBtnBg = if (!isEnabled) {
        SolidColor(buttonDisableColor)
    } else {
        gradient ?: SolidColor(lightBlueColor)
    }

    val btnBg = if (!isEnabled) {
        SolidColor(buttonDisableColor)
    } else {
        SolidColor(lightBlueColor)
    }

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = isEnabled,
//        colors = if (gradient != null) {
//            ButtonDefaults.buttonColors(gradientBtnBg)
//        } else {
//            ButtonDefaults.buttonColors(containerColor = btnBg)
//        },
        onClick = { onButtonClick.invoke() }
    ) {
        Text(text = text, fontWeight = FontWeight.W600, fontSize = 14.sp, lineHeight = 16.sp)
    }
}