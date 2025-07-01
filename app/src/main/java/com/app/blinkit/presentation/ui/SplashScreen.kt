package com.app.blinkit.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.app.blinkit.R

@Composable
fun SplashScreen(navController:NavHostController){
     Scaffold(containerColor = colorResource(R.color.primary)){ innerPadding->
          Column(modifier = Modifier.padding(innerPadding)) {
               Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = null)
          }
     }
}