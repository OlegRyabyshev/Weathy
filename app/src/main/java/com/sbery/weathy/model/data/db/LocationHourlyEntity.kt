package com.sbery.weathy.model.data.db

data class LocationHourlyEntity(
    val time: Int,
    val weatherId: Int,
    val temp: Double
)