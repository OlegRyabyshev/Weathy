package com.sbery.weathy.model.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "location_weather",
    primaryKeys = ["location_lat", "location_lon"]
)
data class LocationWeatherEntity(

    @ColumnInfo(name = "location_lat")
    val locationLat: Double,

    @ColumnInfo(name = "location_lon")
    val locationLon: Double,

    @ColumnInfo(name = "location_save_time")
    val locationSaveTime: Long,

    @ColumnInfo(name = "location_current_temp")
    val locationCurrentTemp: Double,

    @ColumnInfo(name = "location_feels_like_temp")
    val locationFeelsLikeTemp: Double,

    @ColumnInfo(name = "location_hourly_list")
    val locationHourlyWeatherList: List<LocationHourlyEntity>,

    @ColumnInfo(name = "location_daily_list")
    val locationDailyWeatherList: List<LocationDailyEntity>
)