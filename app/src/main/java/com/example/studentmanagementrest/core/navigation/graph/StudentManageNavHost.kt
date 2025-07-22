package com.example.studentmanagementrest.core.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentmanagementrest.core.navigation.bottom_navigation.BottomNavScreen
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.presentation.auth.login.LoginRoute
import com.example.studentmanagementrest.presentation.auth.signup.SignUpRoute

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun StudentManagementNavHost(
    screenRoute: ScreenRoute,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.SignScreen
    ) {
        composable<ScreenRoute.LoginScreen> {
            LoginRoute()
        }

        composable<ScreenRoute.SignScreen> {
            SignUpRoute()
        }

        composable<ScreenRoute.BottomNav> {
            BottomNavScreen(screenRoute)
        }

    }
}