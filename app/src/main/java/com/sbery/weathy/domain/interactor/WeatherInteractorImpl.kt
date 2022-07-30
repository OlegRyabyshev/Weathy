package com.sbery.weathy.domain.interactor

import com.sbery.weathy.domain.repository.WeatherRepository
import com.sbery.weathy.model.domain.WeatherForecast
import javax.inject.Inject

class WeatherInteractorImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
) : WeatherInteractor {

    override suspend fun getWeatherForecast(lat: String, lon: String): WeatherForecast =
        weatherRepository.getWeatherForecast(lat, lon)
}