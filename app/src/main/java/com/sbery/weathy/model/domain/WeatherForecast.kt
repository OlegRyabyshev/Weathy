package com.sbery.weathy.model.domain

import androidx.annotation.DrawableRes

data class WeatherForecast(
    val lat: String,
    val lon: String,
    val temp: Double,
    val feelsLikeTemp: Double,
    val hourlyList: List<TimeBasedForecast>
) {

    data class TimeBasedForecast(
        val hour: Int,
        @DrawableRes
        val iconRes: Int,
        val temp: Double,
    )
}