package com.leanite.github.airbnb.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.data.mock.rioTrip
import com.leanite.github.airbnb.domain.model.Trip
import com.leanite.github.airbnb.ui.theme.FontStyle
import com.leanite.github.airbnb.ui.theme.ThinGrayText
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun TripInfo(
    trip: Trip,
    modifier: Modifier = Modifier
) {
    val guestText = if (trip.amountPeople > 1) {
        stringResource(R.string.trip_info_guests, trip.amountPeople)
    } else {
        stringResource(R.string.trip_info_guest)
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(
                R.string.trip_info_date_range,
                trip.date.initial.dayOfMonth,
                trip.date.end.dayOfMonth,
                trip.date.initial.format(
                    DateTimeFormatter.ofPattern(
                        "MMM", Locale.of("pt", "BR")
                    )
                ),
            ),
            style = FontStyle.TripInfo
        )
        TextSeparator(modifier = Modifier.padding(horizontal = 2.dp))
        Text(
            text = guestText,
            style = FontStyle.TripInfo
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = ThinGrayText,
            modifier = Modifier.height(15.dp),
        )
    }

}

@Composable
@Preview
fun TripInfoPreview() {
    TripInfo(
        trip = rioTrip
    )
}