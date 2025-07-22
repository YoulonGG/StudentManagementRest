package com.example.studentmanagementrest.core.ui_components.dialogs

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

object DialogManager{
    private val _dialogEvents = MutableSharedFlow<DialogEvent>(extraBufferCapacity = 10)
    val dialogEvents: SharedFlow<DialogEvent> = _dialogEvents.asSharedFlow()

    fun showInfoDialog(title: String, message: String) {
        _dialogEvents.tryEmit(DialogEvent.Info(title, message))
    }

}