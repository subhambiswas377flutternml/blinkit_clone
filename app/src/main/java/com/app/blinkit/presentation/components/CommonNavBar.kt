package com.app.blinkit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.blinkit.R
import com.app.blinkit.presentation.Tabs

@Composable
fun CommonNavigationBar(tabController:MutableState<Tabs>){
    Box(modifier = Modifier.fillMaxWidth().height(75.dp)) {
        // Divider
        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalDivider(color = Color(0xFF9C9C9C), modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
        }

        // NavigationBarItem
        Row(modifier = Modifier.fillMaxSize()) {
            CustomNavigationBarItem(imageResource = R.string.home_icon, onClick = {tabController.value = Tabs.HomeTab}, selected = tabController.value==Tabs.HomeTab, modifier = Modifier.weight(1f));
            CustomNavigationBarItem(imageResource = R.string.shopping_icon, onClick = {tabController.value = Tabs.ShopTab}, selected = tabController.value==Tabs.ShopTab,modifier = Modifier.weight(1f) );
            CustomNavigationBarItem(imageResource = R.string.category_icon, onClick = {tabController.value = Tabs.CategoryTab}, selected = tabController.value==Tabs.CategoryTab, modifier = Modifier.weight(1f));
            CustomNavigationBarItem(imageResource = R.string.printer_icon, onClick = {tabController.value = Tabs.PrintTab}, selected = tabController.value==Tabs.PrintTab, modifier = Modifier.weight(1f));
        }
    }
}

@Composable
private fun CustomNavigationBarItem(imageResource:Int, onClick: ()->Unit, selected:Boolean = false, modifier: Modifier){
    Box(contentAlignment = Alignment.Center, modifier = modifier.clickable{ onClick() }) {
        if(selected){
            Column(modifier = Modifier.fillMaxHeight()) {
                Box(modifier = Modifier.width(50.dp).height(3.dp).background(color = Color.Black, shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))){}
            }
        }

        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            AssetSvgView(imageUrl = stringResource(imageResource), modifier = Modifier.size(35.dp))
        }
    }
}