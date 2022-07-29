package com.sbery.weathy.data.converter

import com.sbery.weathy.model.data.response.WeatherResponse
import com.sbery.weathy.model.domain.WeatherForecast

interface WeatherDataToDomainConverter {

    fun convert(dataModel: WeatherResponse): WeatherForecast
}