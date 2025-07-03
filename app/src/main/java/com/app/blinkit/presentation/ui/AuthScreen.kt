package com.app.blinkit.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.blinkit.AppRoutes
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetImageView
import com.app.blinkit.ui.theme.BlinkitTheme

@Composable
fun AuthScreen(navController: NavHostController){
    val screenHeight:Int = LocalConfiguration.current.screenHeightDp
    val phoneNumberFieldController: MutableState<String> = rememberSaveable { mutableStateOf<String>("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Banner Image
            AssetImageView(imagePath = stringResource(R.string.item_banner), modifier = Modifier
                .height((screenHeight * 0.55).dp)
                .fillMaxWidth());

            // App Logo
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                AssetImageView(
                    imagePath = stringResource(R.string.app_icon),
                    modifier = Modifier.size(93.dp)
                )
            };
            Spacer(modifier = Modifier.height(20.dp));
            Text(text = "India’s last minute app", fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp));
            Text(text = "Login or Sign up", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = colorResource(R.color.dark_grey));

            // Phone number text field
            Spacer(modifier = Modifier.height(30.dp));
            Box(modifier = Modifier.padding(16.dp).border(1.dp, shape = RoundedCornerShape(12.dp), color = Color.Gray)) {
                Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically){
                    Text(text = "+91", fontWeight = FontWeight.SemiBold, fontSize = 18.sp);
                    Spacer(modifier = Modifier.width(5.dp));
                    BasicTextField(value = phoneNumberFieldController.value,
                        onValueChange = {it->
                            if(it.length<=10){
                                phoneNumberFieldController.value = it
                            }
                    }, modifier = Modifier.weight(1f),
                        singleLine = true,
                        decorationBox = { innerTextField ->
                            Box { if (phoneNumberFieldController.value.isEmpty()) { Text(text = "Enter mobile number",
                                    fontSize = 18.sp, fontWeight = FontWeight.SemiBold,color = colorResource(R.color.dark_grey)) }
                                innerTextField() }
                        },
                        textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold,color = colorResource(R.color.dark_grey)));
                }
            }

            Button(onClick = {
                navController.navigate(AppRoutes.LandingRoute){
                    popUpTo<AppRoutes.AuthRoute>(){
                        inclusive = true
                    }
                }
            }, modifier = Modifier.fillMaxWidth().padding(16.dp).height(50.dp),
                shape = RoundedCornerShape(12.dp), enabled = phoneNumberFieldController.value.isNotEmpty()&&phoneNumberFieldController.value.length==10,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = colorResource(R.color.dark_grey),
                )) {
                Text(text = "Continue", fontSize = 20.sp,)
            }
        }
    }
}