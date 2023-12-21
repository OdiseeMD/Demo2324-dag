package be.odisee.wolf.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import be.odisee.wolf.R


val exoFont = FontFamily(
    Font(R.font.exo)
)

val wolfFont = FontFamily(
    Font(R.font.wolf)
)

// Set of Material typography styles to start with
val typography = Typography(
    labelMedium = TextStyle(
        fontFamily = exoFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700
    ),
    titleLarge =
    TextStyle(
        fontFamily = wolfFont,
        fontSize = 24.sp,
        platformStyle = PlatformTextStyle(false)
    )
)