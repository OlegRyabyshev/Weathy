package com.sbery.weathy.data.repository

import android.util.Log
import com.sbery.weathy.BuildConfig
import com.sbery.weathy.data.api.WeatherApiMapper
import com.sbery.weathy.data.converter.WeatherDataToDomainConverter
import com.sbery.weathy.data.storage.LocationWeatherStorage
import com.sbery.weathy.domain.repository.WeatherRepository
import com.sbery.weathy.model.data.db.LocationWeatherEntity
import com.sbery.weathy.model.data.request.WeatherRequest
import com.sbery.weathy.model.domain.WeatherForecast
import java.util.logging.Logger
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val locationWeatherStorage: LocationWeatherStorage,
    private val weatherApiMapper: WeatherApiMapper,
    private val weatherConverter: WeatherDataToDomainConverter
) : WeatherRepository {

    override suspend fun getWeatherForecast(lat: Double, lon: Double): WeatherForecast {
        System.currentTimeMillis()


        if (locationWeatherStorage.isLocationWeatherExist(lat, lon)) {
            val storedWeather = locationWeatherStorage.getLocationWeather(lat, lon)
            Log.d(TAG, "Found cached weather")

            if (isStoredCacheValid(storedWeather)) {
                Log.d(TAG, "Cached weather is valid, return")
                return weatherConverter.convert(storedWeather)
            }
        }

        Log.d(TAG, "Can't use cached weather, making an API call")
        return getWeatherForecastFromApiCall(lat, lon)
    }

    private suspend fun getWeatherForecastFromApiCall(
        lat: Double,
        lon: Double
    ): WeatherForecast {
        val requestModel = WeatherRequest(
            lat = lat,
            lon = lon,
            BuildConfig.API_KEY
        )

        val weatherResponse = weatherApiMapper.getWeatherForecast(requestModel)
        val convertedResponse = weatherConverter.convert(weatherResponse)

        cacheWeatherInfo(convertedResponse)

        Log.d(TAG, "Returning weather from an API call")
        return convertedResponse
    }

    private fun isStoredCacheValid(storedWeather: LocationWeatherEntity): Boolean {
        val cacheTime = storedWeather.locationSaveTime
        val currentTime = System.currentTimeMillis()

        if (currentTime - cacheTime < CACHE_PERIOD) {
            return true
        }

        return false
    }

    private suspend fun cacheWeatherInfo(convertedResponse: WeatherForecast) {
        locationWeatherStorage.addLocationWeather(
            weatherConverter.convert(convertedResponse)
        )
    }

    private companion object {
        const val TAG = "WeatherRepositoryImpl"

        /** 30 minutes in ms */
        const val CACHE_PERIOD = 1_800_000L
    }
}