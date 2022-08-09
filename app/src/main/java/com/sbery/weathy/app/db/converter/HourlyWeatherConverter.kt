package com.sbery.weathy.app.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sbery.weathy.model.data.db.LocationHourlyEntity

class HourlyWeatherConverter {

    @TypeConverter
    fun fromHourlyList(value: List<LocationHourlyEntity>): String {
        val type = object : TypeToken<List<LocationHourlyEntity>>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun toHourlyList(value: String): List<LocationHourlyEntity> {
        val type = object : TypeToken<List<LocationHourlyEntity>>() {}.type
        return Gson().fromJson(value, type)
    }
}