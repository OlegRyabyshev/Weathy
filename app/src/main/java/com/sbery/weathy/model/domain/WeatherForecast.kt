package com.sbery.weathy.model.domain

data class WeatherForecast(
    val lat: String,
    val lon: String,
    val temp: Double,
    val feelsLikeTemp: Double
)