package com.sbery.weathy.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sbery.weathy.model.data.db.LocationWeatherEntity

@Dao
interface LocationWeatherDao {

    @Query("SELECT EXISTS(SELECT * FROM location_weather WHERE location_lat = :locationLat AND location_lon = :locationLon)")
    fun isLocationWeatherExist(locationLat: Double, locationLon: Double): Boolean

    @Query("SELECT * FROM location_weather WHERE location_lat = :locationLat AND location_lon = :locationLon")
    fun getLocationWeather(locationLat: Double, locationLon: Double): LocationWeatherEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLocationWeather(entity: LocationWeatherEntity)

    @Update
    fun updateLocationWeather(entity: LocationWeatherEntity)

    @Delete
    fun removeLocationWeather(entity: LocationWeatherEntity)
}