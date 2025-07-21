package com.example.studentmanagementrest.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

@Stable
@Composable
fun getColor(
    isFromText: Boolean = false,
    isError: Boolean = false,
    isFocused: Boolean = false,
    isEmpty: Boolean = false
): Color {
    return if (isError) {
        Color.Red
    } else {
        if (isFocused) {
            if (isEmpty) {
                Color.LightGray
            } else {
                Color.DarkGray
            }
        } else {
            if (isEmpty) {
                Color.LightGray
            } else {
                Color.DarkGray
            }

        }

    }

}
