package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.navigation.sharedImage

@Composable
fun HighlightCard(
    imageRes: Int,
    imageSize: Dp,
    isSuperHost: Boolean,
    modifier: Modifier = Modifier,
    cancel: Boolean = false,
) {
    val cornerRadius = 16.dp

    Box(
        modifier = modifier
            .size(imageSize)
            .clip(RoundedCornerShape(cornerRadius))
    ){
        Image(
            modifier = Modifier.sharedImage(key = "image-${imageRes}", cornerRadius = cornerRadius),
            painter = painterResource(imageRes),
            contentDescription = null,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            if (isSuperHost && cancel == false) {
                SuperHostBadge()
            }
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(imageSize/7),
                alignment = Alignment.TopEnd,
                painter = painterResource(R.drawable.icon_heart_fav),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun HighlightCardPreview() {
    HighlightCard(
        imageRes = R.drawable.apartment_copacabana,
        imageSize = 168.dp,
        isSuperHost = true
    )
}