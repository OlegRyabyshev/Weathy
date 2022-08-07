package com.sbery.weathy.model.data.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @field:SerializedName("lat")
    val lat: Double,
    @field:SerializedName("lon")
    val lon: Double,
    @field:SerializedName("current")
    val current: CurrentResponse,
    @field:SerializedName("hourly")
    val hourly: List<HourlyItemResponse> = emptyList(),
    @field:SerializedName("daily")
    val daily: List<DailyItemResponse> = emptyList()
//    @field:SerializedName("alerts")
//    val alerts: List<AlertsItem> = emptyList(),
//    @field:SerializedName("timezone")
//    val timezone: String? = null,
//    @field:SerializedName("timezone_offset")
//    val timezoneOffset: Int? = null,
//    @field:SerializedName("minutely")
//    val minutely: List<MinutelyItemResponse> = emptyList(),
) {

    data class CurrentResponse(
        @field:SerializedName("dt")
        val dt: Int? = null,
        @field:SerializedName("temp")
        val temp: Double,
        @field:SerializedName("feels_like")
        val feelsLike: Double,
        @field:SerializedName("weather")
        val weather: List<WeatherItem> = emptyList(),
//        @field:SerializedName("sunrise")
//        val sunrise: Int? = null,
//        @field:SerializedName("visibility")
//        val visibility: Int? = null,
//        @field:SerializedName("uvi")
//        val uvi: Double? = null,
//        @field:SerializedName("pressure")
//        val pressure: Int? = null,
//        @field:SerializedName("clouds")
//        val clouds: Int? = null,
//        @field:SerializedName("wind_deg")
//        val windDeg: Int? = null,
//        @field:SerializedName("dew_point")
//        val dewPoint: Double? = null,
//        @field:SerializedName("sunset")
//        val sunset: Int? = null,
//        @field:SerializedName("humidity")
//        val humidity: Int? = null,
//        @field:SerializedName("wind_speed")
//        val windSpeed: Double? = null
    )

    data class DailyItemResponse(
        @field:SerializedName("dt")
        val dt: Int,
        @field:SerializedName("temp")
        val temp: Temp,
        @field:SerializedName("weather")
        val weather: List<WeatherItem> = emptyList(),
//        @field:SerializedName("moonset")
//        val moonset: Int? = null,
//        @field:SerializedName("rain")
//        val rain: Double? = null,
//        @field:SerializedName("sunrise")
//        val sunrise: Int? = null,
//        @field:SerializedName("moon_phase")
//        val moonPhase: Double? = null,
//        @field:SerializedName("uvi")
//        val uvi: Double? = null,
//        @field:SerializedName("moonrise")
//        val moonrise: Int? = null,
//        @field:SerializedName("pressure")
//        val pressure: Int? = null,
//        @field:SerializedName("clouds")
//        val clouds: Int? = null,
//        @field:SerializedName("feels_like")
//        val feelsLike: FeelsLike? = null,
//        @field:SerializedName("wind_gust")
//        val windGust: Double? = null,
//        @field:SerializedName("pop")
//        val pop: Double? = null,
//        @field:SerializedName("wind_deg")
//        val windDeg: Int? = null,
//        @field:SerializedName("dew_point")
//        val dewPoint: Double? = null,
//        @field:SerializedName("sunset")
//        val sunset: Int? = null,
//        @field:SerializedName("humidity")
//        val humidity: Int? = null,
//        @field:SerializedName("wind_speed")
//        val windSpeed: Double? = null
    )

    data class HourlyItemResponse(
        @field:SerializedName("dt")
        val dt: Int,
        @field:SerializedName("temp")
        val temp: Double,
        @field:SerializedName("weather")
        val weather: List<WeatherItem> = emptyList(),
//        @field:SerializedName("rain")
//        val rain: Rain? = null,
//        @field:SerializedName("visibility")
//        val visibility: Int? = null,
//        @field:SerializedName("uvi")
//        val uvi: Double? = null,
//        @field:SerializedName("pressure")
//        val pressure: Int? = null,
//        @field:SerializedName("clouds")
//        val clouds: Int? = null,
//        @field:SerializedName("feels_like")
//        val feelsLike: Double? = null,
//        @field:SerializedName("wind_gust")
//        val windGust: Double? = null,
//        @field:SerializedName("pop")
//        val pop: Double? = null,
//        @field:SerializedName("wind_deg")
//        val windDeg: Int? = null,
//        @field:SerializedName("dew_point")
//        val dewPoint: Double? = null,
//        @field:SerializedName("humidity")
//        val humidity: Int? = null,
//        @field:SerializedName("wind_speed")
//        val windSpeed: Double? = null
    )

    data class Temp(
        @field:SerializedName("min")
        val min: Double,
        @field:SerializedName("max")
        val max: Double,
//        @field:SerializedName("eve")
//        val eve: Double? = null,
//        @field:SerializedName("night")
//        val night: Double? = null,
//        @field:SerializedName("day")
//        val day: Double? = null,
//        @field:SerializedName("morn")
//        val morn: Double? = null
    )

    data class WeatherItem(
        @field:SerializedName("id")
        val id: Int
//        @field:SerializedName("icon")
//        val icon: String? = null,
//        @field:SerializedName("description")
//        val description: String? = null,
//        @field:SerializedName("main")
//        val main: String? = null,
    )

//    data class FeelsLike(
//        @field:SerializedName("eve")
//        val eve: Double? = null,
//        @field:SerializedName("night")
//        val night: Double? = null,
//        @field:SerializedName("day")
//        val day: Double? = null,
//        @field:SerializedName("morn")
//        val morn: Double? = null
//    )

//    data class AlertsItem(
//        @field:SerializedName("start")
//        val start: Int? = null,
//        @field:SerializedName("description")
//        val description: String? = null,
//        @field:SerializedName("sender_name")
//        val senderName: String? = null,
//        @field:SerializedName("end")
//        val end: Int? = null,
//        @field:SerializedName("event")
//        val event: String? = null,
//        @field:SerializedName("tags")
//        val tags: List<String?>? = null
//    )

//    data class MinutelyItemResponse(
//        @field:SerializedName("dt")
//        val dt: Int? = null,
//        @field:SerializedName("precipitation")
//        val precipitation: Int? = null
//    )

//    data class Rain(
//        @field:SerializedName("1h")
//        val jsonMember1h: Double? = null
//    )
}