package com.leanite.github.airbnb.domain.model

data class HomeData(
    val accommodations: List<Accommodation>,
    val neighborhoodAccommodations: List<Accommodation>,
    val places: List<Place>,
    val currentTrip: Trip,
)
