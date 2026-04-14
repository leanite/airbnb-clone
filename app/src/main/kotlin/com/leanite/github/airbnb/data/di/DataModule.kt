package com.leanite.github.airbnb.data.di

import com.leanite.github.airbnb.data.repository.AccommodationRepositoryImpl
import com.leanite.github.airbnb.data.repository.HomeRepositoryImpl
import com.leanite.github.airbnb.domain.repository.AccommodationRepository
import com.leanite.github.airbnb.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindAccommodationRepository(
        impl: AccommodationRepositoryImpl
    ): AccommodationRepository

    @Binds
    abstract fun bindHomeRepository(
        impl: HomeRepositoryImpl
    ): HomeRepository
}
