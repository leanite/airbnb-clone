package com.leanite.github.airbnb.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class DetailRoute(
    val id: Int,
    val title: String,
    val imageRes: Int,
)