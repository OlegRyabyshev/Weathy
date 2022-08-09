package com.sbery.weathy.model.domain

data class WeatherForecast(
    val lat: Double,
    val lon: Double,
    val temp: Double,
    val feelsLikeTemp: Double,
    val hourlyList: List<HourlyForecast>,
    val dailyList: List<DailyForecast>
) {

    data class HourlyForecast(
        val time: Int,
        val weatherId: Int,
        val temp: Double
    )

    data class DailyForecast(
        val time: Int,
        val weatherId: Int,
        val maxTemp: Double,
        val minTemp: Double
    )
}