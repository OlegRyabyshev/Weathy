package com.sbery.weathy.data.api

import com.sbery.weathy.data.retrofit.WeatherApiService
import com.sbery.weathy.model.data.request.WeatherRequest
import com.sbery.weathy.model.data.response.WeatherResponse

class WeatherApiMapperImpl(private val apiService: WeatherApiService) : WeatherApiMapper {

    override suspend fun getWeatherForecast(request: WeatherRequest): WeatherResponse =
        apiService.getAppMetricsReport(
            request.lat,
            request.lon,
            request.apiKey,
            request.exclude,
            request.units,
            request.lang
        )
}