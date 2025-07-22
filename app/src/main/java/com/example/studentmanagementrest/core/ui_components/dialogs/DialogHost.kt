package com.example.studentmanagementrest.core.ui_components.dialogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementrest.core.resource.backgroundColor

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun InfoDialog(title: String, message: String, onDismiss: () -> Unit) {
    AlertDialog(
        containerColor = backgroundColor,
        onDismissRequest = { onDismiss.invoke() },
        icon = {
//            Icon(
//                painter = painterResource(id = AppIcons.icCoin),
//                contentDescription = null,
//                tint = Color.Unspecified,
//                modifier = Modifier
//                    .size(36.dp)
//                    .padding(
//                        start = 8.dp
//                    )
//            )
        },
        title = {
            Text(
                text = title,
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                color = Color.Black

            )
        },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = message,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 18.sp
            )
        },
        confirmButton = {}
    )
}


@Composable
fun SingleActionDialog(
    onDismiss: () -> Unit,
    title: String,
    description: String,
) {
    AlertDialog(
        containerColor = Color.White,
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                text = title,
                fontWeight = FontWeight(700),
                fontSize = 16.sp,

                )
        },
        text = {
            Text(
                text = description,
                textAlign = TextAlign.Start,
                maxLines = 4,

                )
        },
        confirmButton = {
            Button(
                modifier = Modifier.widthIn(min = 80.dp),
                onClick = {
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(
                    text = "Okay",
                    color = Color.White,
                    fontWeight = FontWeight(600),
                    fontSize = 12.sp
                )
            }
        }
    )
}