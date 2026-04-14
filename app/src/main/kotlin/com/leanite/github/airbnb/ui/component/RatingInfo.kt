package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.ui.theme.FontStyle.AccommodationSubTitle
import com.leanite.github.airbnb.ui.theme.ThinGrayText

@Composable
fun RatingInfo(
    highlightText: String,
    rating: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = highlightText,
            style = AccommodationSubTitle,
            color = ThinGrayText,
        )
        TextSeparator(
            modifier = Modifier.padding(horizontal = 2.dp)
        )
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = ThinGrayText,
            modifier = Modifier.size(10.dp)
        )
        Text(
            text = rating.toStringDecimal(),
            style = AccommodationSubTitle,
            color = ThinGrayText
        )
    }
}

private fun Double.toStringDecimal(): String {
    return this.toString().replace('.', ',')
}

@Preview
@Composable
fun RatingInfoPreview() {
    RatingInfo(
        highlightText = "5 camas",
        rating = 4.8
    )
}