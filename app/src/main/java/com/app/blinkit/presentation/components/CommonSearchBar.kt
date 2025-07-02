package com.app.blinkit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.blinkit.R

@Composable
fun CommonSearchBar(searchFieldController: MutableState<String>){
    Box(modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(12.dp)).background(color = Color.White).padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AssetSvgView(imageUrl = stringResource(R.string.search_icon), modifier = Modifier.size(25.dp).clickable {  });
            Spacer(modifier = Modifier.width(6.dp));

            BasicTextField(value = searchFieldController.value,
                maxLines = 1,
                decorationBox = {innerTextField->
                    Box { if (searchFieldController.value.isEmpty()) { Text(text = "Search anything...",
                        fontSize = 20.sp, fontWeight = FontWeight.Normal ,color = colorResource(R.color.dark_grey)
                    ) }
                        innerTextField() }
                },
                onValueChange = {it->
                searchFieldController.value = it
            },
                textStyle = TextStyle(
                    fontSize = 22.sp,
                ),
                modifier = Modifier.weight(1f));

            Spacer(modifier = Modifier.width(6.dp));
            VerticalDivider(modifier = Modifier.height(30.dp), thickness = 3.dp);

            Spacer(modifier = Modifier.width(6.dp));
            AssetSvgView(imageUrl = stringResource(R.string.mic_icon), modifier = Modifier.size(25.dp).clickable {  })
        }
    }
}