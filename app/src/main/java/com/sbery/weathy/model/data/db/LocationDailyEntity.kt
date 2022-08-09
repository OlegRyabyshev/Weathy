package com.sbery.weathy.model.data.db

data class LocationDailyEntity(
    val time: Int,
    val weatherId: Int,
    val maxTemp: Double,
    val minTemp: Double
)