package com.leanite.github.airbnb.domain.model

import java.time.LocalDate

data class DateRange(
    val initial: LocalDate,
    val end: LocalDate,
)