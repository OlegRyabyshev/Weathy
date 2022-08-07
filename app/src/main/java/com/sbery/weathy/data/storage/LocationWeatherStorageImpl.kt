package com.sbery.weathy.data.storage

import com.sbery.weathy.data.db.LocationWeatherDao
import com.sbery.weathy.model.data.db.LocationWeatherEntity

class LocationWeatherStorageImpl(
    private val locationWeatherDao: LocationWeatherDao
) : LocationWeatherStorage {

    override suspend fun isLocationWeatherExist(lat: String, lon: String): Boolean =
        locationWeatherDao.isLocationWeatherExist(lat, lon)

    override suspend fun getLocationWeather(lat: String, lon: String): LocationWeatherEntity =
        locationWeatherDao.getLocationWeather(lat, lon)

    override suspend fun addLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.addLocationWeather(entity)

    override suspend fun updateLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.updateLocationWeather(entity)

    override suspend fun removeLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.removeLocationWeather(entity)
}