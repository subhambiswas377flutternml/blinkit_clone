package com.app.blinkit.presentation.ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetImageView
import com.app.blinkit.presentation.components.ItemSection

@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().padding(top = 3.dp).verticalScroll(scrollState)) {
        // Banner
        AssetImageView(imagePath = stringResource(R.string.diwali_banner), modifier = Modifier.fillMaxWidth());
        Spacer(modifier = Modifier.height(10.dp))

        ItemSection(sectionHeading = "Grocery & Kitchen");
        Spacer(modifier = Modifier.height(30.dp))
        ItemSection(sectionHeading = "Snacks & Drinks");
        Spacer(modifier = Modifier.height(30.dp))
        ItemSection(sectionHeading = "Household Essentials");
    }
}