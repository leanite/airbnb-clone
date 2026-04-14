package com.leanite.github.airbnb.data.datasource

import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.data.mock.neighborhoodAccommodations
import com.leanite.github.airbnb.domain.model.Accommodation
import javax.inject.Inject

internal class AccommodationLocalDataSource @Inject constructor() {

    fun getAccommodations(): List<Accommodation> = allAccommodations

    fun getNeighborhood(): List<Accommodation> = neighborhoodAccommodations

    fun getAccommodationById(id: Int): Accommodation? =
        (allAccommodations + neighborhoodAccommodations).find { it.id == id }
}
