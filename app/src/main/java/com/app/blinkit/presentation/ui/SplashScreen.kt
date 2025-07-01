package com.app.blinkit.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.app.blinkit.R
import com.app.blinkit.presentation.components.SvgImage

@Composable
fun SplashScreen(navController:NavHostController){


     Scaffold(containerColor = colorResource(R.color.primary)){ innerPadding->
          Column(modifier = Modifier.padding(innerPadding).fillMaxSize(), verticalArrangement = Arrangement.Center) {
               SvgImage(imageUrl = stringResource(R.string.app_logo), modifier = Modifier.fillMaxWidth())
          }
     }
}