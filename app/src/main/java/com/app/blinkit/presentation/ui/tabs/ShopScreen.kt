package com.app.blinkit.presentation.ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetImageView
import com.app.blinkit.presentation.components.ItemSection

@Composable
fun ShopScreen(){
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
        Spacer(modifier = Modifier.height(10.dp));
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            AssetImageView(imagePath = stringResource(R.string.filled_cart), modifier = Modifier.size(200.dp));
            Text(text = "Reordering will be easy", fontWeight = FontWeight.Bold, fontSize = 22.sp);
            Text(text = "Items you order will show up here so you can buy\nthem again easily.", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
        };
        Spacer(modifier = Modifier.height(40.dp));
        ItemSection(sectionHeading = "Bestsellers");
        Spacer(modifier = Modifier.height(50.dp));
    }
}