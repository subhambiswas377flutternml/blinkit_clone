package com.app.blinkit.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.blinkit.R

@Composable
fun ItemCard(){
    Column(modifier = Modifier.width(140.dp)) {
        // Image and Button
        Box(modifier = Modifier
            .height(160.dp)
            .width(140.dp)) {
            // Image
            AssetImageView(
                imagePath = stringResource(R.string.diwali_light),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            );

            // Button
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(6.dp),
                    colors = ButtonDefaults.buttonColors().copy(
                        contentColor = MaterialTheme.colorScheme.secondary,
                        containerColor = MaterialTheme.colorScheme.tertiary
                    ),
                    border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.secondary)
                ) {
                    Text(text = "Add", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }
        }

        // Title
        Text(text = "Diwali Light", fontSize = 18.sp, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Bold, maxLines = 2, modifier = Modifier.fillMaxWidth());

        Spacer(modifier = Modifier.height(8.dp));
        // Delivery Duration
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AssetSvgView(imageUrl = stringResource(R.string.timer_icon), modifier = Modifier.size(33.dp));
            Spacer(modifier = Modifier.width(6.dp));
            Text(text = "16 MINS", modifier = Modifier.weight(1f), maxLines = 1, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Normal, color = colorResource(R.color.text_grey), fontSize = 18.sp);
        }

        Spacer(modifier = Modifier.height(8.dp));
        Text(text = "₹79", modifier = Modifier.fillMaxWidth().padding(start = 4.dp), fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}