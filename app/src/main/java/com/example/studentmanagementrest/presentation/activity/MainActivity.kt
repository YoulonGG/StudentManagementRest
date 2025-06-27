package com.example.studentmanagementrest.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.studentmanagementrest.core.navigation.graph.StudentManagementNavHost
import com.example.studentmanagementrest.ui.theme.StudentManagementRestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController()
            StudentManagementRestTheme {
                StudentManagementNavHost(nav)
            }
        }
    }
}

