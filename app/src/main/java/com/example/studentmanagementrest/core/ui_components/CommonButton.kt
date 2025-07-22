package com.example.studentmanagementrest.core.ui_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth().height(48.dp),
        onClick = { onButtonClick.invoke() }
    ) {
        Text(text = text, fontWeight = FontWeight.W600, fontSize = 14.sp, lineHeight = 16.sp)
    }
}