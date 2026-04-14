package com.leanite.github.airbnb.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.ui.component.FannedPhotoCard
import com.leanite.github.airbnb.ui.item.AccommodationItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun LastSeenSection(
    accommodations: ImmutableList<Accommodation>,
    onAccommodationClick: (Accommodation) -> Unit,
    modifier: Modifier = Modifier,
) {
    val imageBaseSize = 112.dp

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(accommodations) { accommodation ->
            AccommodationItem(
                accommodation = accommodation,
                onAccommodationClick = onAccommodationClick,
                imageSize = imageBaseSize,
                showAccommodationType = false,
                cancel = true
            )
        }
        if (accommodations.size < 3) return@LazyRow
        item {
            FannedPhotoCard(
                front = painterResource(accommodations[0].imageRes),
                middle = painterResource(accommodations[1].imageRes),
                back = painterResource(accommodations[2].imageRes),
                baseSize = imageBaseSize
            )
        }
    }
}

@Preview
@Composable
fun LastSeenSectionPreview() {
    LastSeenSection(
        accommodations = allAccommodations.toImmutableList(),
        onAccommodationClick = {}
    )
}