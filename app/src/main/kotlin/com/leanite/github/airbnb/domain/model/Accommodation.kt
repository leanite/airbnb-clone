package com.leanite.github.airbnb.domain.model

data class Accommodation(
    val id: Int,
    val type: String,
    val place: String,
    val price: Int,
    val beds: Int,
    val rating: Double,
    val isSuperHost: Boolean = false,
    val imageRes: Int,
    val shortDescription: String = "",
    val neighborhood: String = "",
    val hostName: String = "",
    val hostMonths: Int = 0,
    val reviews: Int = 0,
    val guests: Int = 2,
    val rooms: Int = 1,
    val bathrooms: Int = 1,
)