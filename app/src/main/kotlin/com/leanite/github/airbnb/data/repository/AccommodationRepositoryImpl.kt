package com.leanite.github.airbnb.data.repository

import com.leanite.github.airbnb.data.datasource.AccommodationLocalDataSource
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.domain.repository.AccommodationRepository
import javax.inject.Inject

internal class AccommodationRepositoryImpl @Inject constructor(
    private val localDataSource: AccommodationLocalDataSource
) : AccommodationRepository {

    override suspend fun getAccommodations(): List<Accommodation> =
        localDataSource.getAccommodations()

    override suspend fun getNeighborhood(): List<Accommodation> =
        localDataSource.getNeighborhood()

    override suspend fun getAccommodationById(id: Int): Accommodation? =
        localDataSource.getAccommodationById(id)
}
