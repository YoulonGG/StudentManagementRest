package com.example.studentmanagementrest.core.ui_components.dialogs

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

sealed class DialogEvent {

    data class SingleAction(
        val dialogData: DialogData,
        val onConfirm: () -> Unit,
    ) : DialogEvent()

    data class MultiAction(
        val dialogData: DialogData,
        val onConfirm: () -> Unit,
        val onDismiss: () -> Unit,
    ) : DialogEvent()

    data class Info(
        val title: String,
        val message: String,
    ) : DialogEvent()

    data class InfoAction(
        val dialogData: DialogData,
        val onConfirm: () -> Unit,
    ) : DialogEvent()

    data class ToggleProgress(
        val canShowProgress: Boolean? = null
    ) : DialogEvent()

    data class NoInternetDialog(
        val title: String,
        val message: String,
        val canShowProgress: Boolean,
        val onRetry: () -> Unit = {}
    ) : DialogEvent()

    data object Dismiss : DialogEvent()
}

