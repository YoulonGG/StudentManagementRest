package com.example.studentmanagementrest.core.events

import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.core.ui_components.dialogs.DialogData

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */
sealed interface NotifyEvents {
    data object Init : NotifyEvents
    data class ToggleLoading(val isLoading: Boolean) : NotifyEvents

    data class Navigate(
        val route: ScreenRoute,
        val currentRoute: ScreenRoute? = null,
    ) : NotifyEvents

    data class ClearBackStack(
        val route: ScreenRoute,
    ) : NotifyEvents


    data class SkipIntermediateRoute(val route : ScreenRoute) : NotifyEvents

    data class ShowModalSheet(
        val showSupportModalSheet: Boolean,
        val showDemoModalSheet: Boolean,
    ) : NotifyEvents

    data class ShowDialog(
        val onConfirmClick : () -> Unit = {},
        val dialogData: DialogData,
    ) : NotifyEvents

//    data class ShowSingleActionDialog(
//        val dialogData: DialogData,
//        val screenRoute: ScreenRoute?= null,
//        val navigateBack : Boolean = false
//
//    ) : NotifyEvents

//    data class ShowInfoDialog(
//        val dialogData: DialogData
//    ) : NotifyEvents

    data object PopBackRoute : NotifyEvents

    data object HideKeyBoard : NotifyEvents

    data object ExitFromApp : NotifyEvents

    data class PopBackRouteAndNavigate(val destination : ScreenRoute) : NotifyEvents

    data class NoInternet(
        val title: String? = null,
        val message: String? = null,
        val needToShowPopUp: Boolean = true
    ) : NotifyEvents

    data class UnAuthorized(val msg: String) : NotifyEvents

    data class ShowToastMessage(val msg: String) : NotifyEvents

    data class ToggleLoadMore(val isLoadMoreLoading: Boolean) : NotifyEvents

//    data class ShowSnackBar(val snackBarUIModel: SnackBarUIModel ) : NotifyEvents
//
//    data class NavigateToBottomNav(val bottomNavScreens: BottomMenuScreens) : NotifyEvents


//    data class ShowError(
//        val dialogData: DialogData,
//        val errorCode: Int? = null,
//        val errorStr: String? = null,
//        val needToShowPopUp: Boolean = true,
//        val needToNavigateBack : Boolean = false,
//        val fromLanguage :Boolean   = false,
//        val onClick : () -> Unit = {}
//    ) : NotifyEvents
}