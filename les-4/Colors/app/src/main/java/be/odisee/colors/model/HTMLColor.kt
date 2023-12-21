package be.odisee.colors.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

data class HTMLColor(val name: String, val hexCode: Long, val categories: List<ColorCategory>) {

    var backgroundColor: Color = Color(hexCode)

    var contrastColor: Color = if (ColorUtils.calculateContrast(
            Color.White.toArgb(),
            backgroundColor.toArgb()
        ) > 2.5
    ) Color.White else Color.Black
}

