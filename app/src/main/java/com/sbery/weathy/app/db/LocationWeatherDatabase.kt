package com.sbery.weathy.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sbery.weathy.app.db.converter.DailyWeatherConverter
import com.sbery.weathy.app.db.converter.HourlyWeatherConverter
import com.sbery.weathy.data.db.LocationWeatherDao
import com.sbery.weathy.model.data.db.LocationWeatherEntity

@Database(
    entities = [LocationWeatherEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    HourlyWeatherConverter::class,
    DailyWeatherConverter::class
)
abstract class LocationWeatherDatabase : RoomDatabase() {

    abstract fun provideLocationWeatherDao(): LocationWeatherDao
}