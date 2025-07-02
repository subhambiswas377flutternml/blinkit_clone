package com.app.blinkit.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonAppBar(){
    val searchFieldController: MutableState<String> = remember { mutableStateOf<String>(value = "") }

    Box(modifier = Modifier.fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(start = 16.dp, end = 16.dp, bottom = 10.dp, top = 35.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Blinkit in", fontWeight = FontWeight.Bold, fontSize = 20.sp);
                    Text(text = "8 minutes", letterSpacing = 0.sp, maxLines = 1, fontWeight = FontWeight.Bold, fontSize = 30.sp);
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {  }) {
                        Text(text = "Kasba, Kolkata", fontWeight = FontWeight.Bold, fontSize = 15.sp);
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null);
                    }
                };

                Spacer(modifier = Modifier.width(3.dp));

                Box(modifier = Modifier.background(color = Color.White, shape = CircleShape).clickable {  }.padding(10.dp)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(30.dp))
                };
            };
            Spacer(modifier = Modifier.height(10.dp));
            // Search Bar
            CommonSearchBar(searchFieldController = searchFieldController);
        }
    }
}