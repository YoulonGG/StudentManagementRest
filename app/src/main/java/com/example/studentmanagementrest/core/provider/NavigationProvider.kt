package com.example.studentmanagementrest.core.provider

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.get
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

class NavigationProvider(
    private val navController: NavController,
    private val activity: Activity,
) {
    private var startTime = 0L
    private val endTime = 500L

    fun navigate(route: ScreenRoute) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - startTime < endTime) {
            return
        }
        startTime = currentTime
        navController.navigate(route)
    }

    fun saveStateAndNavigate(route: ScreenRoute) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }

    fun navigateAndCloseCurrent(route: ScreenRoute) {
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }


    fun popUpToUntilRouteAndClearBackStack(route: ScreenRoute) {
        navController.navigate(route) {
            popUpTo(navController.graph[route].id) {
                inclusive = true
            }
        }
    }

    fun navigateBackPreservingState(
        route: ScreenRoute
    ) {
        navController.navigate(route) {
            popUpTo(route) {
                inclusive = false
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }

    fun clearIntermediate(routeToClear: ScreenRoute, currentRoute: ScreenRoute) {
        navController.navigate(currentRoute) {
            popUpTo(routeToClear) { inclusive = true }
            launchSingleTop = true
        }
    }

    fun navigateLaunchSingleTop(route: ScreenRoute) {
        navController.navigate(route) {
            if (isScreenInBackStack(route)) {
                popUpTo(route) {
                    inclusive = true
                }
            }
        }
    }

    fun validateAndGoBack(destination: ScreenRoute) {
        if (isScreenInBackStack(destination)) {
            goBack()
        } else {
            finishActivity()
        }
    }

    fun finishActivity() {
        activity.finishAffinity()
    }

    private fun isScreenInBackStack(route: ScreenRoute): Boolean {
        return try {
            navController.getBackStackEntry(route)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun goBack() {
        //this below check is added to prevent accidental click on the back button
        //and this check will prevent white screen display
        if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
            navController.popBackStack()
        }
    }
}

val LocalNavigationManager = staticCompositionLocalOf<NavigationProvider> {
    error("No NavigationManager provided")
}