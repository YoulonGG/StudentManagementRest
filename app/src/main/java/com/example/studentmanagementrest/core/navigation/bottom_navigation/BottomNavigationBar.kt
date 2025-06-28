package com.example.studentmanagementrest.core.navigation.bottom_navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.studentmanagementrest.R
import com.example.studentmanagementrest.core.navigation.util.ScreenRoute

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

data class NavigationItem(
    val title: String, val icon: Int, val route: ScreenRoute
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = R.drawable.ic_launcher_background,
            route = ScreenRoute.HomeScreen
        ),
        NavigationItem(
            title = "Student",
            icon = R.drawable.ic_launcher_background,
            route = ScreenRoute.StudentScreen
        ),
        NavigationItem(
            title = "Course",
            icon = R.drawable.ic_launcher_background,
            route = ScreenRoute.CourseScreen
        ),
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index, onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                }, icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = item.title,
                        tint = if (index == selectedNavigationIndex.intValue) MaterialTheme.colorScheme.primary
                        else Color.Gray
                    )

                }, label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue) Color.Black
                        else Color.Gray
                    )
                }, colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                )

            )
        }
    }
}
