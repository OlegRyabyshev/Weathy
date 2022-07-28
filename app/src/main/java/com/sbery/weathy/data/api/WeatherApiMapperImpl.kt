package com.sbery.weathy.data.api

import com.sbery.weathy.data.retrofit.WeatherApiService
import com.sbery.weathy.model.data.request.WeatherRequestModel
import com.sbery.weathy.model.data.response.WeatherResponseModel

class WeatherApiMapperImpl(
    private val apiService: WeatherApiService
) : WeatherApiMapper {

    override suspend fun getWeatherForecast(requestModel: WeatherRequestModel): WeatherResponseModel =
        apiService.getAppMetricsReport(
            requestModel.lat,
            requestModel.lon,
            requestModel.apiKey,
            requestModel.exclude,
            requestModel.units,
            requestModel.lang
        )
}