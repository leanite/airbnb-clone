package com.leanite.github.airbnb.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.ui.theme.FontStyle

@Composable
fun HeaderSection(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = FontStyle.Header,
            modifier = Modifier.weight(0.8f)
        )
        Spacer(Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = Color(0xFFF0F0F0),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun HeaderSectionPreview() {
    HeaderSection(title = "Acomodações em Rio de Janeiro com cancelamento gratuito")
}