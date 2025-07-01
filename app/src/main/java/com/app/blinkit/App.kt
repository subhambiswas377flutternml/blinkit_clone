package com.app.blinkit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.blinkit.presentation.ui.SplashScreen
import kotlinx.serialization.Serializable

object AppRoutes{
    @Serializable
    data object SplashScreen
}

@Composable
fun BlinkitApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.SplashScreen) {
        composable<AppRoutes.SplashScreen> {
            SplashScreen(navController = navController)
        }
    }
}