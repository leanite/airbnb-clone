package com.leanite.github.airbnb.domain.usecase

import com.leanite.github.airbnb.core.result.AppError
import com.leanite.github.airbnb.core.result.AppResult
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.domain.repository.AccommodationRepository
import javax.inject.Inject

class GetAccommodationByIdUseCase @Inject constructor(
    private val repository: AccommodationRepository
) {
    suspend operator fun invoke(id: Int): AppResult<Accommodation> = try {
        val accommodation = repository.getAccommodationById(id)
        if (accommodation != null) {
            AppResult.Success(accommodation)
        } else {
            AppResult.Error(AppError.NotFound(id))
        }
    } catch (e: Exception) {
        AppResult.Error(AppError.Unknown)
    }
}
