package com.leanite.github.airbnb.domain.repository

import com.leanite.github.airbnb.domain.model.HomeData

interface HomeRepository {
    suspend fun getHomeData(): HomeData
}
