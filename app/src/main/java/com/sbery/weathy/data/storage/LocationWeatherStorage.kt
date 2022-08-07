package com.sbery.weathy.data.storage

import com.sbery.weathy.model.data.db.LocationWeatherEntity

interface LocationWeatherStorage {

    suspend fun isLocationWeatherExist(lat: Double, lon: Double): Boolean

    suspend fun getLocationWeather(lat: Double, lon: Double): LocationWeatherEntity

    suspend fun addLocationWeather(entity: LocationWeatherEntity)

    suspend fun updateLocationWeather(entity: LocationWeatherEntity)

    suspend fun removeLocationWeather(entity: LocationWeatherEntity)
}