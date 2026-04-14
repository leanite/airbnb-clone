package com.leanite.github.airbnb.data.datasource

import com.leanite.github.airbnb.data.mock.rioTrip
import com.leanite.github.airbnb.domain.model.Trip
import javax.inject.Inject

internal class TripLocalDataSource @Inject constructor() {

    fun getCurrentTrip(): Trip = rioTrip
}
