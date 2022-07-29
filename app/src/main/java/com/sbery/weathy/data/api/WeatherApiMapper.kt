package com.sbery.weathy.data.api

import com.sbery.weathy.model.data.request.WeatherRequestModel
import com.sbery.weathy.model.data.response.WeatherResponseModel

interface WeatherApiMapper {

    suspend fun getWeatherForecast(requestModel: WeatherRequestModel): WeatherResponseModel
}