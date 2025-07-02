package com.app.blinkit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.blinkit.presentation.LandingScreen
import com.app.blinkit.presentation.ui.AuthScreen
import com.app.blinkit.presentation.ui.SplashScreen
import kotlinx.serialization.Serializable

object AppRoutes{
    @Serializable
    data object SplashRoute

    @Serializable
    data object AuthRoute

    @Serializable
    data object LandingRoute
}

@Composable
fun BlinkitApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.SplashRoute) {

        composable<AppRoutes.SplashRoute> {
            SplashScreen(navController = navController)
        }

        composable<AppRoutes.AuthRoute> {
            AuthScreen(navController = navController)
        }

        composable<AppRoutes.LandingRoute> {
            LandingScreen(navContrller = navController)
        }
    }
}