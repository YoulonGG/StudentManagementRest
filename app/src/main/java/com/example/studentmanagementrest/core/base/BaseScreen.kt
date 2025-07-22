package com.example.studentmanagementrest.core.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studentmanagementrest.core.events.CollectEventsFromVM
import com.example.studentmanagementrest.core.events.NotifyEvents
import com.example.studentmanagementrest.core.provider.LocalNavigationManager
import com.example.studentmanagementrest.core.ui_components.dialogs.DialogData
import com.example.studentmanagementrest.core.ui_components.dialogs.DialogManager
import com.example.studentmanagementrest.core.ui_components.dialogs.DialogType
import com.example.studentmanagementrest.core.ui_components.dialogs.OnDialogEvents
import com.example.studentmanagementrest.shared.findActivity
import com.example.studentmanagementrest.shared.showToast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */
@Composable
internal fun BaseScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    notifyEventsChannel: Flow<NotifyEvents>,
    dialogEvents: (OnDialogEvents) -> Unit = {},
    content: @Composable () -> Unit,
) {

    val navigator = LocalNavigationManager.current
    val activity = LocalContext.current.findActivity()
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        content = {
            CollectEventsFromVM(flow = notifyEventsChannel) { event ->
                when (event) {
                    NotifyEvents.ExitFromApp -> navigator.finishActivity()
                    is NotifyEvents.HideKeyBoard -> {
//                        scope.launch {
//                            keyboardManager.hideKeyboard()
//                        }
                    }

                    is NotifyEvents.Navigate -> {
                        DialogManager.dismissDialog()
//                        keyboardManager.hideKeyboard()
                        navigator.navigate(event.route)
                    }


                    is NotifyEvents.SkipIntermediateRoute -> {
                        navigator.saveStateAndNavigate(event.route)
                    }

                    is NotifyEvents.ToggleLoading -> {
                        DialogManager.toggleProgress(event.isLoading)
                    }

                    is NotifyEvents.NoInternet -> {
                        DialogManager.showNoInternet(
                            title = event.title.toString(),
                            message = event.message.toString(),
                            onRetry = {
                                dialogEvents.invoke(OnDialogEvents.ON_RETRY)
                            })
                    }

                    is NotifyEvents.ShowToastMessage -> {
                        activity?.showToast(event.msg)
                    }

                    is NotifyEvents.ShowError -> {
                        if (event.needToShowPopUp) {
                            if (event.dialogData.dialogType == DialogType.INFO) {
                                DialogManager.showInfoDialog(
                                    title = event.dialogData.title,
                                    message = event.dialogData.description.toString()
                                )
                            } else {
                                DialogManager.showSingleActionDialog(event.dialogData) {
                                    if (event.needToNavigateBack) {
                                        dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)
                                        navigator.goBack()
                                    } else {
                                        event.onClick.invoke()
                                        dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)

                                    }
                                }
                            }
                        } else {
                            activity?.showToast(
                                event.dialogData.description.toString()
                            )
                        }
                    }

                    is NotifyEvents.ShowDialog -> {
                        DialogManager.showMultiActionDialog(
                            event.dialogData,
                            onConfirm = {
                                dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)
                            },
                            onDismiss = {
                                dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)
                            },
                        )
                    }

                    is NotifyEvents.ShowInfoDialog -> {
                        DialogManager.showInfoDialog(
                            title = event.dialogData.title,
                            message = event.dialogData.description.toString()
                        )
                    }


                    NotifyEvents.PopBackRoute -> {
                        DialogManager.dismissDialog()
//                        scope.launch {
//                            keyboardManager.hideKeyboard()
//                        }
                        navigator.goBack()
                    }

                    is NotifyEvents.PopBackRouteAndNavigate -> {
                        DialogManager.dismissDialog()
                        scope.launch {
//                            keyboardManager.hideKeyboard()
                        }
                        navigator.popUpToUntilRouteAndClearBackStack(event.destination)
                    }

                    is NotifyEvents.ShowSingleActionDialog -> {
                        DialogManager.showSingleActionDialog(
                            DialogData(
                                title = event.dialogData.title,
                                description = event.dialogData.description,
                            ),
                            onConfirm = {
                                dialogEvents.invoke(OnDialogEvents.POSITIVE_CLICK)
                                if (event.navigateBack) {
                                    navigator.goBack()
                                } else {
                                    event.screenRoute?.let {
                                        navigator.navigateAndCloseCurrent(
                                            it
                                        )
                                    }
                                }
                            },
                        )
                    }

                    is NotifyEvents.ClearBackStack -> {
                        DialogManager.dismissDialog()
                        scope.launch {
//                            keyboardManager.hideKeyboard()
                        }
                        navigator.popUpToUntilRouteAndClearBackStack(event.route)
                    }

//                    is NotifyEvents.UnAuthorized -> {
//                        UserManager.clearToken()
//                        UserManager.saveToken("")
//                        val snackBarUIModel = SnackBarUIModel(
//                            icon = AppIcons.icError,
//                            titleColor = errorHeaderTextColor,
//                            message = event.msg,
//                            borderColor = errorBorderColor,
//                            backgroundColor = errorToastBgColor,
//                            title = LMSLanguageProvider.translate(StringRes.ERROR)
//
//                        )
//                        SnackbarManager.showSnackbar(snackBarUIModel)
//                        delay(200)
//                        navigator.navigate(ScreenRoute.LoginScreen(true))
//                    }

//                    is NotifyEvents.ShowSnackBar -> {
//                        SnackbarManager.showSnackbar(event.snackBarUIModel)
//
////                            scope.launch {
////                                snackBarUIModel = SnackBarUIModel(
////                                    icon = event.snackBarUIModel.icon,
////                                    titleColor = event.snackBarUIModel.titleColor,
////                                    message = event.snackBarUIModel.message,
////                                    borderColor = event.snackBarUIModel.borderColor,
////                                    backgroundColor = event.snackBarUIModel.backgroundColor,
////                                    title = event.snackBarUIModel.title
////
////                                )
////                                showSnackBar.value = true
////                                snackBarHostState.currentSnackbarData?.dismiss()
////                                snackBarHostState.showSnackbar(
////                                    message = event.snackBarUIModel.title,
////                                    actionLabel = event.snackBarUIModel.message,
////                                    duration = SnackbarDuration.Short
////                                )
////                            }
//                    }
//
//                    is NotifyEvents.NavigateToBottomNav -> {
//                        bottomNavState.navigateToBottomMenuScreens(
//                            BottomMenuScreens.REQUEST
//                        )
//                    }


                    else -> Unit
                }
            }
            content()
        },
    )


}