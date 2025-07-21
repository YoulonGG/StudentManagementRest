package com.example.studentmanagementrest.core.ui_components.dialogs

import androidx.annotation.Keep
import androidx.compose.ui.graphics.Color

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */


@Keep
data class DialogData(
    val title: String,
    val description: String? = null,
    val positiveBtnText: String = "Okay",
    val negativeBtnText: String = "Cancel",
    val positiveBtnColor: Color = Color.Blue, // need to change
    val negativeBtnColor: Color = Color.Red, // need to change
    val autoDismissTime: Long = 2L,
    val dialogType: DialogType = DialogType.NONE
)

@Keep
enum class DialogType {
    SINGLE, MULTI, INFO, NONE
}