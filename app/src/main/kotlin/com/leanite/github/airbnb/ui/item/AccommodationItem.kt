package com.leanite.github.airbnb.ui.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.navigation.sharedText
import com.leanite.github.airbnb.ui.component.HighlightCard
import com.leanite.github.airbnb.ui.component.RatingInfo
import com.leanite.github.airbnb.ui.theme.FontStyle.AccommodationTitle

@Composable
fun AccommodationItem(
    accommodation: Accommodation,
    onAccommodationClick: (Accommodation) -> Unit,
    imageSize: Dp,
    showAccommodationType: Boolean = true,
    modifier: Modifier = Modifier,
    cancel: Boolean = false,
) {
    val titleText = if (showAccommodationType) {
        "${accommodation.type} • ${accommodation.place}"
    } else {
        accommodation.place
    }
    val ratingText = if (showAccommodationType) {
        stringResource(R.string.accommodation_price_info, accommodation.price)
    } else {
        if (accommodation.beds == 1) {
            stringResource(R.string.accommodation_bed_info)
        } else {
            stringResource(R.string.accommodation_beds_info, accommodation.beds)
        }
    }

    Column(
        modifier = modifier
            .width(imageSize)
            .clickable { onAccommodationClick(accommodation) }
    ) {
        HighlightCard(
            imageRes = accommodation.imageRes,
            isSuperHost = accommodation.isSuperHost,
            imageSize = imageSize,
            cancel = cancel
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = titleText,
            style = AccommodationTitle,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
        RatingInfo(
            highlightText = ratingText,
            rating = accommodation.rating
        )
    }
}

@Preview
@Composable
fun AccommodationItemPreview() {
    AccommodationItem(
        accommodation = allAccommodations[0],
        imageSize = 168.dp,
        onAccommodationClick = {},
        showAccommodationType = false
    )
}