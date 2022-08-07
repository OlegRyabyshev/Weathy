package com.sbery.weathy.di

import com.sbery.weathy.data.api.WeatherApiMapper
import com.sbery.weathy.data.api.WeatherApiMapperImpl
import com.sbery.weathy.data.converter.WeatherDataToDomainConverter
import com.sbery.weathy.data.converter.WeatherDataToDomainConverterImpl
import com.sbery.weathy.data.repository.WeatherRepositoryImpl
import com.sbery.weathy.data.storage.LocationWeatherStorage
import com.sbery.weathy.data.storage.LocationWeatherStorageImpl
import com.sbery.weathy.domain.interactor.WeatherInteractor
import com.sbery.weathy.domain.interactor.WeatherInteractorImpl
import com.sbery.weathy.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BinderModule {

    @Binds
    abstract fun bindWeatherApiMapper(impl: WeatherApiMapperImpl): WeatherApiMapper

    @Binds
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    abstract fun bindWeatherInteractor(impl: WeatherInteractorImpl): WeatherInteractor

    @Binds
    abstract fun bindWeatherDataToDomainConverter(impl: WeatherDataToDomainConverterImpl): WeatherDataToDomainConverter

    @Binds
    abstract fun bindLocationWeatherStorage(impl: LocationWeatherStorageImpl): LocationWeatherStorage
}