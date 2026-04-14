package com.leanite.github.airbnb.data.mock

import com.leanite.github.airbnb.domain.model.DateRange
import com.leanite.github.airbnb.domain.model.Trip
import java.time.LocalDate

val rioTrip = Trip(
    date = DateRange(
        initial = LocalDate.of(2025, 7, 30),
        end = LocalDate.of(2025, 7, 31)
    ),
    place = "Rio de Janeiro",
    amountPeople = 4
)
