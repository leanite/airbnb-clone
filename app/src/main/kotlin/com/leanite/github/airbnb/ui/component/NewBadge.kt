package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import com.leanite.github.airbnb.ui.theme.AirbnbFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp

// Ideia:
// 1) Fazer um shape com 3 pontas arredondadas e uma quadrada
// 2) Colocar sombra nesse Box principal
// 3) Colocar um background com gradiente normal
// 4) Fazer 2 draws:
//      um para o contorno da metade superior da Badge
//      outro para o contorno da metade inferior da Badge
// 5) Contraste com o gradiente do fundo principal:
//      corpo: topo escuro, centro mais escuro, base clara
//      borda: topo claro, centro mais escuro, base escura
@Composable
fun NewBadge(
    text: String = "NOVO",
    collapseProgress: Float,
    modifier: Modifier = Modifier
) {
    val badgeAlpha = 1f - collapseProgress
    val badgeScale = lerp(1f, 0.5f, collapseProgress)
    val badgeHeight = lerpDp(16.dp, 0.dp, collapseProgress)

    val badgeShape = RoundedCornerShape(
        topStart = 10.dp,
        topEnd = 10.dp,
        bottomStart = 0.dp,
        bottomEnd = 10.dp,
    )
    val middleColor = Color(0xFF476282)
    val darkColor = Color(0xFF354665)
    val lightColor = Color(0xFF778da9)

    Box(
        modifier = modifier
            .height(badgeHeight)
            .graphicsLayer {
                shadowElevation = 10.dp.toPx()
                shape = badgeShape
                clip = false
                ambientShadowColor = darkColor
                spotShadowColor = darkColor
                alpha = badgeAlpha
                scaleX = badgeScale
                scaleY = badgeScale
            }
            // fundo em gradiente
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.00f to middleColor.copy(alpha = 0.70f),
                        0.30f to darkColor,
                        0.70f to darkColor,
                        1.00f to lightColor
                    )),
                shape = badgeShape
            )
            .padding(horizontal = 5.dp, vertical = 3.dp)
    ) {
        Text(
            text = text,
            fontFamily = AirbnbFont,
            color = Color(0xFFDADDE2),
            fontWeight = FontWeight.Medium,
            fontSize = 9.sp,
        )
    }
}

private fun lerpDp(start: Dp, stop: Dp, fraction: Float): Dp {
    return start + (stop - start) * fraction
}

@Preview
@Composable
fun NewBadgePreview() {
    NewBadge(
        collapseProgress = 0f
    )
}