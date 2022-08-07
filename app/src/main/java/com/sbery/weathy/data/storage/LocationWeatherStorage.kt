package com.sbery.weathy.data.storage

import com.sbery.weathy.model.data.db.LocationWeatherEntity

interface LocationWeatherStorage {

    suspend fun isLocationWeatherExist(lat: String, lon: String): Boolean

    suspend fun getLocationWeather(lat: String, lon: String): LocationWeatherEntity

    suspend fun addLocationWeather(entity: LocationWeatherEntity)

    suspend fun updateLocationWeather(entity: LocationWeatherEntity)

    suspend fun removeLocationWeather(entity: LocationWeatherEntity)
}