package com.example.studentmanagementrest.presentation.splash

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SplashRoute(
    navController: NavHostController,
) {
    SplashScreen(
        onNavigate = navController
    )
}