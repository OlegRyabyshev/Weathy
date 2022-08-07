package com.sbery.weathy.presentation.screens.weather

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sbery.weathy.R
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.model.domain.WeatherForecast.DailyForecast
import com.sbery.weathy.model.domain.WeatherForecast.HourlyForecast

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel = hiltViewModel()) {
    weatherViewModel.loadWeatherForecast(55.0, 37.0)

    when (val state = weatherViewModel.weatherUiState.value) {
        is WeatherUiState.Forecast -> ForecastScreen(state.weatherForecast)
        is WeatherUiState.Loading -> ShimmerForecastScreen()
        is WeatherUiState.Error -> ErrorAlert(state.error)
    }
}

@Composable
fun ForecastScreen(forecast: WeatherForecast) {
    Surface(color = Color.White) {
        Text(text = forecast.temp.toString())
    }
}

@Composable
fun ShimmerForecastScreen() {

}

@Composable
fun HourlyScrollableForecast(hourlyList: List<HourlyForecast>) {

}

@Composable
fun DailyScrollableForecast(dailyList: List<DailyForecast>) {

}

@Composable
fun ErrorAlert(error: String) {
    Text(text = error)
}

@Preview
@Composable
fun WeatherScreenPreview() {
    ForecastScreen(
        forecast = WeatherForecast(
            55.54,
            34.23,
            22.0,
            26.0,
            listOf(HourlyForecast(123, R.drawable.wc_cloud, 36.0)),
            listOf(DailyForecast(123, R.drawable.wc_lightning, 35.0, -23.0))
        )
    )
}