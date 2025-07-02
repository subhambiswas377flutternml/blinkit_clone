package com.app.blinkit.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.app.blinkit.presentation.components.CommonAppBar

@Composable
fun LandingScreen(navContrller: NavHostController){
    val screenHeight:Int = LocalConfiguration.current.screenHeightDp

    Scaffold(
        // App Bar
        topBar = { CommonAppBar() }
    ) {innerPadding->
        Box(modifier = Modifier.padding(innerPadding)) {  }
    }
}