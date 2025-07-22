package com.example.studentmanagementrest.core.ui_components.dialogs

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

sealed class DialogEvent {
    data class Info(
        val title: String,
        val message: String,
    ) : DialogEvent()
}
