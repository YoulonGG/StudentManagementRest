package com.example.studentmanagementrest.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentmanagementrest.core.events.NotifyEvents
import com.example.studentmanagementrest.core.ui_components.dialogs.DialogData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */
abstract class BaseViewModel<UiState, UiAction>(
    private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    abstract fun setInitialState(): UiState

    abstract fun onAction(event: UiAction)

    private val initialState: UiState by lazy { setInitialState() }

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val notifyEvents = Channel<NotifyEvents>(capacity = 10)
    val notifyEventsChannel = notifyEvents.receiveAsFlow()

    protected fun setState(reducer: UiState.() -> UiState) {
        viewModelScope.launch(mainDispatcher) {
            val newState = uiState.value.reducer()
            _uiState.value = newState
        }
    }

    fun sendEvent(event: NotifyEvents) {
        viewModelScope.launch(mainDispatcher) {
            notifyEvents.trySend(event)
        }
    }

    fun handleToastError(error: Throwable?) {
        sendEvent(
            NotifyEvents.ShowDialog(
                dialogData = DialogData(
                    title = "Error",
                    description = error?.message ?: "An unexpected error occurred.",
                )
            )
        )
    }
}