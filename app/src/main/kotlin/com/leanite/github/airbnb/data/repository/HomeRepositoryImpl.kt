package com.leanite.github.airbnb.data.repository

import com.leanite.github.airbnb.data.datasource.AccommodationLocalDataSource
import com.leanite.github.airbnb.data.datasource.PlaceLocalDataSource
import com.leanite.github.airbnb.data.datasource.TripLocalDataSource
import com.leanite.github.airbnb.domain.model.HomeData
import com.leanite.github.airbnb.domain.repository.HomeRepository
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val accommodationDataSource: AccommodationLocalDataSource,
    private val placeDataSource: PlaceLocalDataSource,
    private val tripDataSource: TripLocalDataSource,
) : HomeRepository {

    override suspend fun getHomeData(): HomeData = HomeData(
        accommodations = accommodationDataSource.getAccommodations(),
        neighborhoodAccommodations = accommodationDataSource.getNeighborhood(),
        places = placeDataSource.getPlaces(),
        currentTrip = tripDataSource.getCurrentTrip(),
    )
}
