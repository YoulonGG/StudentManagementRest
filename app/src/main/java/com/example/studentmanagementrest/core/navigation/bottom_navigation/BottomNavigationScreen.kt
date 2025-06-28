package com.example.studentmanagementrest.core.navigation.bottom_navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.presentation.course.CourseRoute
import com.example.studentmanagementrest.presentation.home.HomeRoute
import com.example.studentmanagementrest.presentation.student.StudentRoute

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */


@Composable
fun BottomNavScreen(bottomNavScreen: ScreenRoute) {
    val navController = rememberNavController()
    Scaffold(snackbarHost = {

    }, bottomBar = {
        Column {
            BottomNavigationBar(
                navController = navController,
//                screenRoute = bottomNavScreen
            )
        }
    }) { paddingValue ->
        Surface(
            modifier = Modifier
                .consumeWindowInsets(paddingValue)
                .fillMaxSize()
//                .background(LMSAppThemeColors.primaryContainer)

        ) {
            BottomMenuNavHost(navController = navController)
        }
    }
}

@Composable
fun BottomMenuNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeScreen
    ) {
        composable<ScreenRoute.HomeScreen> {
            HomeRoute()
        }

        composable<ScreenRoute.StudentScreen> {
            StudentRoute()
        }

        composable<ScreenRoute.CourseScreen> {
            CourseRoute()
        }
    }

}

