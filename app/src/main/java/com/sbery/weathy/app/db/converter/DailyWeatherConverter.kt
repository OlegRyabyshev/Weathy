package com.sbery.weathy.app.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sbery.weathy.model.data.db.LocationDailyEntity

class DailyWeatherConverter {

    @TypeConverter
    fun fromDailyList(value: List<LocationDailyEntity>): String {
        val type = object : TypeToken<List<LocationDailyEntity>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toDailyList(value: String): List<LocationDailyEntity> {
        val type = object : TypeToken<List<LocationDailyEntity>>() {}.type
        return Gson().fromJson(value, type)
    }
}