package com.leanite.github.airbnb.domain.model

data class Trip(
    val date: DateRange,
    val place: String,
    val amountPeople: Int
)

