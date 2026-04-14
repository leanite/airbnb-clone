package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leanite.github.airbnb.ui.theme.AirbnbFont
import com.leanite.github.airbnb.ui.theme.BlackishText

@Composable
fun SuperHostBadge(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.8f), RoundedCornerShape(8.dp))
            .padding(6.dp)
    ) {
        Text(
            text = "Preferido dos\nhóspedes",
            fontFamily = AirbnbFont,
            fontSize = 12.sp,
            color = BlackishText,
            fontWeight = FontWeight.Medium

        )
    }
}

@Preview
@Composable
fun SuperHostBadgePreview() {
    SuperHostBadge()
}