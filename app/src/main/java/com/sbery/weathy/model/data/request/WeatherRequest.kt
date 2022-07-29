package com.sbery.weathy.model.data.request

data class WeatherRequest(
    val lat: String,
    val lon: String,
    val apiKey: String,
    val exclude: String = "alert",
    val units: String = "metric",
    val lang: String = "en"
)