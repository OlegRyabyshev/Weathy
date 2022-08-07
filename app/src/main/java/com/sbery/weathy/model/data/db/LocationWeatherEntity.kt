package com.sbery.weathy.model.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@Entity(
    tableName = "location_weather",
    primaryKeys = ["location_lat", "location_lon"]
)
data class LocationWeatherEntity(

    @ColumnInfo(name = "location_lat")
    val locationLat: String,

    @ColumnInfo(name = "location_lon")
    val locationLon: String,

    @ColumnInfo(name = "location_save_time")
    val locationSaveTime: Long,

    @ColumnInfo(name = "location_name")
    val locationName: String,

    @ColumnInfo(name = "location_current_temp")
    val locationCurrentTemp: String
)

class DataConverter {

    @TypeConverter
    fun fromCountryLangList(countryLang: List<CountryLang>): String {
        val type: Type = object : TypeToken<List<CountryLang>>() {}.type
        return Gson().toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String): List<CountryLang> {
        val type: Type = object : TypeToken<List<CountryLang?>?>() {}.type
        return Gson().fromJson<List<CountryLang>>(countryLangString, type)
    }
}