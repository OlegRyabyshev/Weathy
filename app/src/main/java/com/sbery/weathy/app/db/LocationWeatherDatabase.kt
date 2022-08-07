package com.sbery.weathy.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sbery.weathy.data.db.LocationWeatherDao
import com.sbery.weathy.model.data.db.LocationWeatherEntity

@Database(
    entities = [LocationWeatherEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LocationWeatherDatabase : RoomDatabase() {

    abstract fun provideLocationWeatherDao(): LocationWeatherDao
}