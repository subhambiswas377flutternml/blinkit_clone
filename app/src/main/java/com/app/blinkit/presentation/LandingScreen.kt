package com.app.blinkit.presentation

import PrintScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.app.blinkit.presentation.components.CommonAppBar
import com.app.blinkit.presentation.components.CommonNavigationBar
import com.app.blinkit.presentation.ui.tabs.CategoryScreen
import com.app.blinkit.presentation.ui.tabs.HomeScreen
import com.app.blinkit.presentation.ui.tabs.ShopScreen

enum class Tabs{
    HomeTab,
    ShopTab,
    CategoryTab,
    PrintTab,

}

@Composable
fun LandingScreen(navContrller: NavHostController){
    val tabController: MutableState<Tabs> = rememberSaveable { mutableStateOf<Tabs>(value = Tabs.HomeTab) }

    Scaffold(
        // App Bar
        topBar = { CommonAppBar() },
        bottomBar = { CommonNavigationBar(tabController = tabController) }
    ) {innerPadding->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when(tabController.value){
                Tabs.HomeTab-> { HomeScreen() }
                Tabs.ShopTab-> { ShopScreen() }
                Tabs.CategoryTab-> { CategoryScreen() }
                Tabs.PrintTab-> { PrintScreen() }
            }
        }
    }
}