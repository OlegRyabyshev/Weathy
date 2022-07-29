package com.sbery.weathy.domain.interactor

import com.sbery.weathy.domain.repository.WeatherRepository
import com.sbery.weathy.model.domain.WeatherForecast

class WeatherInteractorImpl(
    private val weatherRepository: WeatherRepository
) : WeatherInteractor {

    override suspend fun getWeatherForecast(lat: String, lon: String): WeatherForecast =
        weatherRepository.getWeatherForecast(lat, lon)
}