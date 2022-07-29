package com.sbery.weathy.model.data.request

data class WeatherRequestModel(
    val lat: String,
    val lon: String,
    val apiKey: String = "42c363b9de547ba20ac2edde454068bd",
    val exclude: String = "alert",
    val units: String = "metric",
    val lang: String = "en"
)