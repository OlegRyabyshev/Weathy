package com.sbery.weathy.domain.interactor

import com.sbery.weathy.model.domain.WeatherForecast

interface WeatherInteractor {

    suspend fun getWeatherForecast(lat: String, lon: String): WeatherForecast
}