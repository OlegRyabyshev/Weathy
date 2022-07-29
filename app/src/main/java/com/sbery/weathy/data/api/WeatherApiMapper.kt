package com.sbery.weathy.data.api

import com.sbery.weathy.model.data.request.WeatherRequest
import com.sbery.weathy.model.data.response.WeatherResponse

interface WeatherApiMapper {

    suspend fun getWeatherForecast(request: WeatherRequest): WeatherResponse
}