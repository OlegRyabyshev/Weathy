package com.sbery.weathy.data.converter

import com.sbery.weathy.model.data.response.WeatherResponse
import com.sbery.weathy.model.domain.WeatherForecast

class WeatherDataToDomainConverterImpl : WeatherDataToDomainConverter {

    override fun convert(dataModel: WeatherResponse): WeatherForecast {

        val lat = dataModel.lat ?: throw IllegalArgumentException()
        val lon = dataModel.lon ?: throw IllegalArgumentException()
        val temp = dataModel.current?.temp ?: throw IllegalArgumentException()
        val feelsLikeTemp = dataModel.current.feelsLike ?: throw IllegalArgumentException()

        return WeatherForecast(
            lat.toString(),
            lon.toString(),
            temp,
            feelsLikeTemp
        )
    }
}