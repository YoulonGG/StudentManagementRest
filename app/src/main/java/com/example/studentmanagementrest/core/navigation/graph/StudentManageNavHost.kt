package com.example.studentmanagementrest.core.navigation.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentmanagementrest.core.navigation.bottom_navigation.BottomNavScreen
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.presentation.auth.login.LoginRoute
import com.example.studentmanagementrest.presentation.auth.signup.SignUpRoute
import com.example.studentmanagementrest.presentation.auth.signup.signup_name.SignUpNameRoute
import com.example.studentmanagementrest.presentation.splash.SplashRoute
import kotlinx.coroutines.delay

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
        startDestination = ScreenRoute.SplashScreen
    ) {

        composable<ScreenRoute.SplashScreen> {
            SplashRoute(navController)
        }

        composable<ScreenRoute.LoginScreen> {
            LoginRoute(navController)
        }

        composable<ScreenRoute.SignScreen> {
            SignUpRoute(navController)
        }

        composable<ScreenRoute.SignUpNameScreen> {
            SignUpNameRoute(navController)
        }

        composable<ScreenRoute.BottomNav> {
            BottomNavScreen(screenRoute)
        }

    }
}