package com.sbery.weathy.data.retrofit

import com.sbery.weathy.model.data.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiService {

    @GET("data/3.0/onecall?")
    suspend fun getAppMetricsReport(
        // required
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appId: String,
        // optional
        @Query("exclude") exclude: String,
        @Query("units") units: String,
        @Query("lang") lang: String,
    ): WeatherResponse

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
    }
}