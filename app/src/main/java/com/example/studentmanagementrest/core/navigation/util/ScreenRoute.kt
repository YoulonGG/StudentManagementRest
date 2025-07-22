package com.example.studentmanagementrest.core.navigation.util

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@Keep
@Serializable
sealed class ScreenRoute {

    @Serializable
    data object LoginScreen: ScreenRoute()

    @Serializable
    data object SignScreen: ScreenRoute()

    @Serializable
    data object BottomNav: ScreenRoute()

    @Serializable
    data object HomeScreen: ScreenRoute()

    @Serializable
    data object StudentScreen: ScreenRoute()

    @Serializable
    data object CourseScreen: ScreenRoute()


}