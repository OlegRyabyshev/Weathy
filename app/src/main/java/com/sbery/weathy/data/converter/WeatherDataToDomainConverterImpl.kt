package com.sbery.weathy.data.converter

import com.sbery.weathy.R
import com.sbery.weathy.model.data.response.WeatherResponse
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.model.domain.WeatherForecast.TimeBasedForecast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDataToDomainConverterImpl @Inject constructor() : WeatherDataToDomainConverter {

    override fun convert(dataModel: WeatherResponse): WeatherForecast {
        val lat = dataModel.lat ?: throw IllegalArgumentException()
        val lon = dataModel.lon ?: throw IllegalArgumentException()
        val temp = dataModel.current?.temp ?: throw IllegalArgumentException()
        val feelsLikeTemp = dataModel.current.feelsLike ?: throw IllegalArgumentException()

        val hourlyList: List<TimeBasedForecast> = dataModel.hourly?.map {
            val hour = it?.dt ?: throw IllegalArgumentException()
            val iconRes = it.weather?.first()?.id?.toIconResource() ?: throw IllegalArgumentException()
            val hourlyTemp = it.temp ?: throw IllegalArgumentException()

            TimeBasedForecast(hour, iconRes, hourlyTemp)
        } ?: throw IllegalArgumentException()



        return WeatherForecast(
            lat.toString(),
            lon.toString(),
            temp,
            feelsLikeTemp,
            hourlyList
        )
    }

    private fun Int.toIconResource(): Int =
        when (this) {

            // Thunderstorm
            200 -> R.drawable.wc_lightning
            201 -> R.drawable.wc_lightning
            202 -> R.drawable.wc_lightning
            210 -> R.drawable.wc_lightning
            211 -> R.drawable.wc_lightning
            212 -> R.drawable.wc_lightning
            221 -> R.drawable.wc_lightning
            230 -> R.drawable.wc_lightning
            231 -> R.drawable.wc_lightning
            232 -> R.drawable.wc_lightning

            in 200..299 -> R.drawable.wc_lightning

            // Drizzle
            300 -> R.drawable.wc_drizzle
            301 -> R.drawable.wc_drizzle
            302 -> R.drawable.wc_drizzle
            310 -> R.drawable.wc_drizzle
            311 -> R.drawable.wc_drizzle
            312 -> R.drawable.wc_drizzle
            313 -> R.drawable.wc_drizzle
            314 -> R.drawable.wc_drizzle
            321 -> R.drawable.wc_drizzle

            in 300..399 -> R.drawable.wc_drizzle

            // Rain
            500 -> R.drawable.wc_rain
            501 -> R.drawable.wc_rain
            502 -> R.drawable.wc_rain
            503 -> R.drawable.wc_rain
            504 -> R.drawable.wc_rain
            511 -> R.drawable.wc_rain
            520 -> R.drawable.wc_rain
            521 -> R.drawable.wc_rain
            531 -> R.drawable.wc_rain

            in 500..599 -> R.drawable.wc_rain

            // Snow
            600 -> R.drawable.wc_snow_alt
            601 -> R.drawable.wc_snow_alt
            602 -> R.drawable.wc_snow_alt
            611 -> R.drawable.wc_snow_alt
            612 -> R.drawable.wc_snow_alt
            613 -> R.drawable.wc_snow_alt
            615 -> R.drawable.wc_snow_alt
            616 -> R.drawable.wc_snow_alt
            620 -> R.drawable.wc_snow_alt
            621 -> R.drawable.wc_snow_alt
            622 -> R.drawable.wc_snow_alt

            in 600..699 -> R.drawable.wc_snow_alt

            // Atmosphere
            701 -> R.drawable.wc_fog
            711 -> R.drawable.wc_fog
            721 -> R.drawable.wc_fog
            731 -> R.drawable.wc_fog
            741 -> R.drawable.wc_fog
            751 -> R.drawable.wc_fog
            761 -> R.drawable.wc_fog
            762 -> R.drawable.wc_fog
            771 -> R.drawable.wc_fog
            781 -> R.drawable.wc_fog

            in 700..799 -> R.drawable.wc_fog

            // Clear & Clouds
            800 -> R.drawable.wc_sun
            801 -> R.drawable.wc_cloud
            802 -> R.drawable.wc_cloud
            803 -> R.drawable.wc_cloud
            804 -> R.drawable.wc_cloud

            else -> R.drawable.wc_cloud
        }
}