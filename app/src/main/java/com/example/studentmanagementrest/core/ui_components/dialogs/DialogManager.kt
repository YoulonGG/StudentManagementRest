package com.example.studentmanagementrest.core.ui_components.dialogs

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

object DialogManager {
    private val _dialogEvents = MutableSharedFlow<DialogEvent>(extraBufferCapacity = 10)
    val dialogEvents: SharedFlow<DialogEvent> = _dialogEvents.asSharedFlow()

    fun showSingleActionDialog(dialogData: DialogData, onConfirm: () -> Unit) {
        _dialogEvents.tryEmit(DialogEvent.SingleAction(dialogData, onConfirm))
    }

    fun toggleProgress(canShowLoading: Boolean) {
        _dialogEvents.tryEmit(DialogEvent.ToggleProgress(canShowLoading))
    }

    fun showMultiActionDialog(dialogData: DialogData, onConfirm: () -> Unit, onDismiss: () -> Unit) {
        _dialogEvents.tryEmit(DialogEvent.MultiAction(dialogData, onConfirm, onDismiss))
    }

    fun showInfoDialog(title: String, message: String) {
        _dialogEvents.tryEmit(DialogEvent.Info(title, message))
    }

    fun showNoInternet(title: String, message: String, onRetry: () -> Unit) {
        _dialogEvents.tryEmit(
            DialogEvent.NoInternetDialog(
                title = title,
                message = message,
                canShowProgress = true,
                onRetry = onRetry
            )
        )
    }

    fun dismissDialog() {
        _dialogEvents.tryEmit(DialogEvent.Dismiss)
    }
}
