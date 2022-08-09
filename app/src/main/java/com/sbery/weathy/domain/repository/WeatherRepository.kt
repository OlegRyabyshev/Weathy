package com.sbery.weathy.domain.repository

import com.sbery.weathy.model.domain.WeatherForecast

interface WeatherRepository {

    suspend fun getWeatherForecast(lat: Double, lon: Double): WeatherForecast
}