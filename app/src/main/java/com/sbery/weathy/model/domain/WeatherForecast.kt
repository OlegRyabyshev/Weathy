package com.sbery.weathy.model.domain

import androidx.annotation.DrawableRes

data class WeatherForecast(
    val lat: Double,
    val lon: Double,
    val temp: Int,
    val feelsLikeTemp: Int,
    val hourlyList: List<HourlyForecast>,
    val dailyList: List<DailyForecast>
) {

    data class HourlyForecast(
        val time: Int,
        @DrawableRes
        val iconRes: Int,
        val temp: Int
    )

    data class DailyForecast(
        val time: Int,
        @DrawableRes
        val iconRes: Int,
        val maxTemp: Int,
        val minTemp: Int
    )
}