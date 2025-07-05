package com.app.blinkit.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.app.blinkit.AppRoutes
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetImageView
import com.app.blinkit.presentation.components.CustomTextField
import com.app.blinkit.presentation.provider.app.AppState
import com.app.blinkit.presentation.provider.app.AppViewModel
import com.app.blinkit.presentation.provider.signup.SignupState
import com.app.blinkit.presentation.provider.signup.SignupViewModel
import com.app.blinkit.presentation.provider.signup.isLoading

enum class AuthMode{
    SignUp,
    Login,
}

@Composable
fun AuthScreen(navController: NavHostController){
    val screenHeight:Int = LocalConfiguration.current.screenHeightDp
    val appContext:Context = LocalContext.current
    val emailController: MutableState<String> = rememberSaveable { mutableStateOf<String>(value = "") }
    val passwordController: MutableState<String> = rememberSaveable { mutableStateOf<String>(value = "") }

    val authModeState: MutableState<AuthMode> = remember { mutableStateOf<AuthMode>(value = AuthMode.Login) }

    val signupViewModel = viewModel<SignupViewModel>()
    val appViewModel = viewModel<AppViewModel>()

    LaunchedEffect(appViewModel.state.value) {
        when(appViewModel.state.value){
            is AppState.Authenticated-> {
                Toast.makeText(appContext, "Welcome", Toast.LENGTH_LONG).show()
                navController.navigate(AppRoutes.LandingRoute){
                    popUpTo<AppRoutes.AuthRoute>(){
                        inclusive = true
                    }
                }
            }
            is AppState.UnAuthenticated-> {
                val error: Exception? = (appViewModel.state.value as AppState.UnAuthenticated).ex
                Toast.makeText(appContext, error?.message?:"Something went wrong!", Toast.LENGTH_LONG).show()
            }
            else->{}
        }
    }

    LaunchedEffect(signupViewModel.state.value) {
        when(signupViewModel.state.value){
            is SignupState.Loaded-> {
                val authData = (signupViewModel.state.value as SignupState.Loaded).authData
                appViewModel.authenticate(authData = authData)
            }else->{}
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {

        Column(modifier = Modifier.fillMaxSize()) {
            // Banner Image
            AssetImageView(imagePath = stringResource(R.string.item_banner), modifier = Modifier
                .height((screenHeight * 0.48).dp)
                .fillMaxWidth());

            // App Logo
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                AssetImageView(
                    imagePath = stringResource(R.string.app_icon),
                    modifier = Modifier.size(93.dp)
                )
            };
            Spacer(modifier = Modifier.height(10.dp));
            Text(text = "India’s last minute app", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

            Text(text = if(authModeState.value==AuthMode.SignUp)"Signup" else "Login", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = colorResource(R.color.dark_grey));

            // Phone number text field
            Spacer(modifier = Modifier.height(30.dp));
            CustomTextField(controller = emailController, hintText = "Enter email...");
            CustomTextField(controller = passwordController, hintText = "Enter password...");

            Button(onClick = {
                signupViewModel.signUp(email = emailController.value.trim(), password = passwordController.value.trim())
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
                shape = RoundedCornerShape(12.dp), enabled = emailController.value.isNotEmpty()&&passwordController.value.isNotEmpty(),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = colorResource(R.color.dark_grey),
                )) {
                if(signupViewModel.state.value.isLoading()){
                    CircularProgressIndicator()
                }else{
                    Text(text = "Continue", fontSize = 20.sp,)
                }
            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Switch to ");
                Text(text =  if(authModeState.value==AuthMode.SignUp) "Login" else "Signup", textAlign = TextAlign.Center, textDecoration = TextDecoration.Underline, color = Color.Blue,
                    modifier = Modifier.clickable {
                        if(authModeState.value==AuthMode.SignUp){
                            authModeState.value = AuthMode.Login
                        }else{
                            authModeState.value = AuthMode.SignUp
                        }
                    })
            }
        }
    }
}