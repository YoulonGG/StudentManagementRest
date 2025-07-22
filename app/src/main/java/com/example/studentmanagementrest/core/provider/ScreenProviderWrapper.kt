package com.example.studentmanagementrest.core.provider

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import kotlinx.coroutines.flow.StateFlow

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun ScreenProviderWrapper(
    activity: ComponentActivity,
    navController: NavController,
//    theme: StateFlow<ThemeProvider.Theme>,
    content: @Composable () -> Unit
) {
//    val mKeyboardManager = remember(activity) {
//        LMSKeyboardManager(activity)
//    }

    val mNavigationManager = remember(navController) {
        NavigationProvider(navController, activity)
    }
//    val lmsThemeProvider = remember { LMSThemeProvider(theme) }
//    val lmsLanguageProvider = remember { LMSLanguageProvider() }

    CompositionLocalProvider(
//        LocalLMSKeyBoardManager provides mKeyboardManager,
        LocalNavigationManager provides mNavigationManager,
//        LocaleLanguageTranslation provides lmsLanguageProvider,
//        LocalCryptoTheme provides lmsThemeProvider,
    ) {
        content()
    }
}