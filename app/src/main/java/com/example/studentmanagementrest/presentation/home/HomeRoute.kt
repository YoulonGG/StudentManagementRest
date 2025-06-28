package com.example.studentmanagementrest.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @Author: John Youlong.
 * @Date: 6/28/25.
 * @Email: johnyoulong@gmail.com.
 */

@Composable
fun HomeRoute() {

    val viewModel: HomeViewModel = hiltViewModel()

    HomeScreen()
}