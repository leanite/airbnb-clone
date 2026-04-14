package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ContentShadow(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    elevation: Dp = 12.dp,
    shadowPadding: PaddingValues = PaddingValues(12.dp), // espaço pra sombra fora
    clipContent: Boolean = true,
) {
    Box(
        modifier = modifier
            .padding(shadowPadding)
            .shadow(elevation = elevation, shape = shape, clip = false)
            .then(if (clipContent) Modifier.clip(shape) else Modifier)
    ) {
        content()
    }
}

@Preview
@Composable
fun ContentShadowPreview() {
    ContentShadow(
        content = {
            Text(
                text = "Content with shadow",
                modifier = Modifier.padding(16.dp)
            )
        }
    )
}