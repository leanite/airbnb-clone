package com.leanite.github.airbnb.domain.usecase

import com.leanite.github.airbnb.core.result.AppError
import com.leanite.github.airbnb.core.result.AppResult
import com.leanite.github.airbnb.domain.model.HomeData
import com.leanite.github.airbnb.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): AppResult<HomeData> = try {
        AppResult.Success(repository.getHomeData())
    } catch (e: Exception) {
        AppResult.Error(AppError.Unknown)
    }
}
