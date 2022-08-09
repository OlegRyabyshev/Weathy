package com.sbery.weathy.model.data.request

data class WeatherRequest(
    val lat: Double,
    val lon: Double,
    val apiKey: String,
    val exclude: String = "alert",
    val units: String = "metric",
    val lang: String = "en"
)