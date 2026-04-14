package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.data.mock.rioTrip
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.domain.model.Trip
import com.leanite.github.airbnb.ui.theme.FontStyle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SearchPlaceBanner(
    trip: Trip,
    accommodations: ImmutableList<Accommodation>,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, shape = shape)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(0.8f),
        ) {
            Text(
                text = stringResource(R.string.continue_searching_place, trip.place),
                style = FontStyle.TripBannerTitle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(6.dp))
            TripInfo(
                trip = trip,
            )
        }
        StackedPhoto(
            front = painterResource(accommodations[0].imageRes),
            middle = painterResource(accommodations[1].imageRes),
            back = painterResource(accommodations[2].imageRes)
        )
    }
}

@Preview
@Composable
fun SearchPlaceBannerPreview() {
    SearchPlaceBanner(
        trip = rioTrip,
        accommodations = allAccommodations.toImmutableList(),
    )
}