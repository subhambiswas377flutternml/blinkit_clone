package com.app.blinkit.presentation.ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.blinkit.presentation.components.CategorySection

@Composable
fun CategoryScreen(){
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
        Spacer(modifier = Modifier.height(10.dp));

        CategorySection(categoryName = "Grocery & Kitchen")
        CategorySection(categoryName = "Watches and Lifestyle")
        CategorySection(categoryName = "Household Essentials")
    }
}