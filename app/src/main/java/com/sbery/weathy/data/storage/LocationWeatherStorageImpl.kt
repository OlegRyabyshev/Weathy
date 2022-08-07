package com.sbery.weathy.data.storage

import com.sbery.weathy.data.db.LocationWeatherDao
import com.sbery.weathy.model.data.db.LocationWeatherEntity
import javax.inject.Inject

class LocationWeatherStorageImpl @Inject constructor(
    private val locationWeatherDao: LocationWeatherDao
) : LocationWeatherStorage {

    override suspend fun isLocationWeatherExist(lat: Double, lon: Double): Boolean =
        locationWeatherDao.isLocationWeatherExist(lat, lon)

    override suspend fun getLocationWeather(lat: Double, lon: Double): LocationWeatherEntity =
        locationWeatherDao.getLocationWeather(lat, lon)

    override suspend fun addLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.addLocationWeather(entity)

    override suspend fun updateLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.updateLocationWeather(entity)

    override suspend fun removeLocationWeather(entity: LocationWeatherEntity) =
        locationWeatherDao.removeLocationWeather(entity)
}