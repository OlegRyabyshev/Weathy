package com.sbery.weathy.data.repository

import com.sbery.weathy.BuildConfig
import com.sbery.weathy.data.api.WeatherApiMapper
import com.sbery.weathy.data.converter.WeatherDataToDomainConverter
import com.sbery.weathy.domain.repository.WeatherRepository
import com.sbery.weathy.model.data.request.WeatherRequest
import com.sbery.weathy.model.domain.WeatherForecast
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApiMapper: WeatherApiMapper,
    private val weatherConverter: WeatherDataToDomainConverter
) : WeatherRepository {

    override suspend fun getWeatherForecast(lat: String, lon: String): WeatherForecast {
        val requestModel = WeatherRequest(
            lat = lat,
            lon = lon,
            BuildConfig.API_KEY
        )

        val weatherResponse = weatherApiMapper.getWeatherForecast(requestModel)
        return weatherConverter.convert(weatherResponse)
    }
}