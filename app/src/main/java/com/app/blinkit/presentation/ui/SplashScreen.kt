package com.app.blinkit.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.app.blinkit.AppRoutes
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetSvgView
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavHostController){

     LaunchedEffect(Unit) {
          delay(1000L)
          navController.navigate(AppRoutes.LandingRoute){
               popUpTo(AppRoutes.SplashRoute){
                    inclusive = true
               }
          }
//          navController.navigate(AppRoutes.AuthRoute){
//               popUpTo(AppRoutes.SplashRoute){
//                    inclusive = true
//               }
//          }
     }

     Scaffold(containerColor = colorResource(R.color.primary)){ innerPadding->
          Column(modifier = Modifier.padding(innerPadding).fillMaxSize(), verticalArrangement = Arrangement.Center) {
               AssetSvgView(imageUrl = stringResource(R.string.app_logo), modifier = Modifier.fillMaxWidth())
          }
     }
}