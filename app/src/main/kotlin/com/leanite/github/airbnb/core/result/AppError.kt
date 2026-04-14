package com.leanite.github.airbnb.core.result

sealed interface AppError {
    data object Unknown : AppError
    data class NotFound(val id: Any) : AppError
}
