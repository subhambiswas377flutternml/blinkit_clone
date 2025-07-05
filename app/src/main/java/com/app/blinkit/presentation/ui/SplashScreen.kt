package com.app.blinkit.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.app.blinkit.AppRoutes
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetSvgView
import com.app.blinkit.presentation.provider.app.AppState
import com.app.blinkit.presentation.provider.app.AppViewModel
import com.app.blinkit.presentation.provider.app.isLoading

@Composable
fun SplashScreen(navController:NavHostController){
     val appViewModel = viewModel<AppViewModel>()

     LaunchedEffect(Unit) {
          appViewModel.checkAuthentication()
     }

     LaunchedEffect(appViewModel.state.value) {
          when(appViewModel.state.value){
               is AppState.Authenticated-> {
                    navController.navigate(AppRoutes.LandingRoute){
                         popUpTo<AppRoutes.SplashRoute>(){
                              inclusive = true
                         }
                    }
               }
               is AppState.UnAuthenticated-> {
                    navController.navigate(AppRoutes.AuthRoute){
                         popUpTo<AppRoutes.SplashRoute>(){
                              inclusive = true
                         }
                    }
               }
               else-> {}
          }
     }

     Scaffold(containerColor = colorResource(R.color.primary)){ innerPadding->
          Box {
               Column(
                    modifier = Modifier
                         .padding(innerPadding)
                         .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
               ) {
                    AssetSvgView(
                         imageUrl = stringResource(R.string.app_logo),
                         modifier = Modifier.fillMaxWidth()
                    )
               };

               if(appViewModel.state.value.isLoading()){
                    Column(modifier = Modifier.fillMaxSize().padding(bottom = 60.dp), verticalArrangement = Arrangement.Bottom) {
                         Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                              CircularProgressIndicator(color = MaterialTheme.colorScheme.tertiary)
                         }
                    };
               }
          }
     }
}