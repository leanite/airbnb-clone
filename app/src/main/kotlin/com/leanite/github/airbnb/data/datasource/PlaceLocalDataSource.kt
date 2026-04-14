package com.leanite.github.airbnb.data.datasource

import com.leanite.github.airbnb.data.mock.allPlaces
import com.leanite.github.airbnb.domain.model.Place
import javax.inject.Inject

internal class PlaceLocalDataSource @Inject constructor() {

    fun getPlaces(): List<Place> = allPlaces
}
