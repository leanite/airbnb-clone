package com.leanite.github.airbnb.domain.repository

import com.leanite.github.airbnb.domain.model.Accommodation

interface AccommodationRepository {
    suspend fun getAccommodations(): List<Accommodation>
    suspend fun getNeighborhood(): List<Accommodation>
    suspend fun getAccommodationById(id: Int): Accommodation?
}
