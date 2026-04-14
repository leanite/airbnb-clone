package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leanite.github.airbnb.ui.theme.LightSeparator

@Composable
fun TextSeparator(
    size: Int = 11,
    color: Color = LightSeparator,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = "•",
            color = color,
            fontSize = size.sp,
        )
    }
}

@Preview
@Composable
fun TextSeparatorPreview() {
    TextSeparator()
}