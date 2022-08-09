package com.sbery.weathy.data.converter

import com.sbery.weathy.model.data.db.LocationDailyEntity
import com.sbery.weathy.model.data.db.LocationHourlyEntity
import com.sbery.weathy.model.data.db.LocationWeatherEntity
import com.sbery.weathy.model.data.response.WeatherResponse
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.model.domain.WeatherForecast.DailyForecast
import com.sbery.weathy.model.domain.WeatherForecast.HourlyForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDataToDomainConverterImpl @Inject constructor() : WeatherDataToDomainConverter {

    override fun convert(dataModel: WeatherResponse): WeatherForecast {
        val lat = dataModel.lat
        val lon = dataModel.lon

        val currentTemp = dataModel.current.temp
        val currentFeelsTemp = dataModel.current.feelsLike

        val hourlyList: List<HourlyForecast> = dataModel.hourly.map {
            val hourTime = it.dt
            val weatherId = it.weather.firstOrNull()?.id ?: throw IllegalArgumentException()
            val temp = it.temp

            HourlyForecast(
                hourTime,
                weatherId,
                temp
            )
        }

        val dailyList: List<DailyForecast> = dataModel.daily.map {
            val dayTime = it.dt
            val weatherId = it.weather.firstOrNull()?.id ?: throw IllegalArgumentException()
            val maxTemp = it.temp.max
            val minTemp = it.temp.min

            DailyForecast(
                dayTime,
                weatherId,
                maxTemp,
                minTemp
            )
        }

        return WeatherForecast(
            lat,
            lon,
            currentTemp,
            currentFeelsTemp,
            hourlyList,
            dailyList
        )
    }

    override fun convert(dataModel: LocationWeatherEntity): WeatherForecast =
        WeatherForecast(
            dataModel.locationLat,
            dataModel.locationLon,
            dataModel.locationCurrentTemp,
            dataModel.locationFeelsLikeTemp,
            dataModel.locationHourlyWeatherList.map { HourlyForecast(it.time, it.weatherId, it.temp) },
            dataModel.locationDailyWeatherList.map { DailyForecast(it.time, it.weatherId, it.maxTemp, it.minTemp) }
        )

    override fun convert(convertedResponse: WeatherForecast): LocationWeatherEntity =
        LocationWeatherEntity(
            convertedResponse.lat,
            convertedResponse.lon,
            System.currentTimeMillis(),
            convertedResponse.temp,
            convertedResponse.feelsLikeTemp,
            convertedResponse.hourlyList.map { LocationHourlyEntity(it.time, it.weatherId, it.temp) },
            convertedResponse.dailyList.map { LocationDailyEntity(it.time, it.weatherId, it.maxTemp, it.minTemp) }
        )
}