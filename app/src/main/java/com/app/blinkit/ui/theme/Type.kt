package com.app.blinkit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.blinkit.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = CustomFontFamily.poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

class CustomFontFamily{
    companion object{
        val poppinsFontFamily: FontFamily = FontFamily(
            androidx.compose.ui.text.font.Font(R.font.poppins_black, weight = FontWeight.Black),
            androidx.compose.ui.text.font.Font(R.font.poppins_bold, weight = FontWeight.Bold),
            androidx.compose.ui.text.font.Font(R.font.poppins_extralight, weight = FontWeight.ExtraLight),
            androidx.compose.ui.text.font.Font(R.font.poppins_light, weight = FontWeight.Light),
            androidx.compose.ui.text.font.Font(R.font.poppins_medium, weight = FontWeight.Medium),
            androidx.compose.ui.text.font.Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
            androidx.compose.ui.text.font.Font(R.font.poppins_thin, weight = FontWeight.Thin),
            androidx.compose.ui.text.font.Font(R.font.poppins_extrabold, weight = FontWeight.ExtraBold),
            androidx.compose.ui.text.font.Font(R.font.poppins_regular, weight = FontWeight.Normal),
        )
    }
}