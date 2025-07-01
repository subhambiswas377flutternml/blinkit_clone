package com.app.blinkit.presentation.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.app.blinkit.core.SvgLoader

@Composable
fun SvgImage(imageUrl:String, modifier: Modifier = Modifier){
    val context: Context = LocalContext.current

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .build(),
        imageLoader = SvgLoader.svgLoader,
        contentScale = ContentScale.Fit
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
    )
}