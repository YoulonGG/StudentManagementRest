package com.example.studentmanagementrest.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute
import com.example.studentmanagementrest.core.provider.UserManager
import kotlinx.coroutines.delay

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun SplashScreen(
    onNavigate: NavHostController
) {

    LaunchedEffect(Unit) {
        delay(3000)
        if (UserManager.getToken().isNullOrEmpty()) {
            onNavigate.navigate(ScreenRoute.LoginScreen)
        } else {
            onNavigate.navigate(ScreenRoute.BottomNav)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
//                Image(
//                    painter = painterResource(id = R.drawable.logo),
//                    contentDescription = "App Logo",
//                    modifier = Modifier.size(100.dp)
//                )
    }

}