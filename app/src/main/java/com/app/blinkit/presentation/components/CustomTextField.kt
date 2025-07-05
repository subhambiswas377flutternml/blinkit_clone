package com.app.blinkit.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.blinkit.R

@Composable
fun CustomTextField(controller: MutableState<String>, prefix:String? = null, hintText: String = "Enter"){
    Box(modifier = Modifier.padding(16.dp).border(1.dp, shape = RoundedCornerShape(12.dp), color = Color.Gray)) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically){
            if(prefix!=null){
                Text(text = "+91", fontWeight = FontWeight.SemiBold, fontSize = 18.sp);
                Spacer(modifier = Modifier.width(5.dp));
            }
            BasicTextField(value = controller.value,
                onValueChange = {it->
                    controller.value = it
//                    if(it.length<=10){
//                        controller.value = it
//                    }
                }, modifier = Modifier.weight(1f),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box { if (controller.value.isEmpty()) { Text(text = hintText,
                        fontSize = 18.sp, fontWeight = FontWeight.SemiBold,color = colorResource(R.color.dark_grey)
                    ) }
                        innerTextField() }
                },
                textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold,color = colorResource(
                    R.color.dark_grey)
                )
            );
        }
    }
}