package com.sbery.weathy.presentation.screens.weather

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.model.domain.WeatherForecast.TimeBasedForecast

@Composable
fun WeatherScreen() {
    val weatherViewModel = hiltViewModel<WeatherViewModel>()

    weatherViewModel.loadWeatherForecast("55", "37")

    when (val state = weatherViewModel.weatherUiState.value) {
        is WeatherUiState.Forecast -> ForecastScreen(state.weatherForecast)
        is WeatherUiState.Error -> ErrorAlert(state.error)
        is WeatherUiState.Loading -> ShimmerForecast()
    }
}

@Composable
fun ErrorAlert(error: String) {
    Text(text = error)
}

@Composable
fun ForecastScreen(forecast: WeatherForecast) {
    ConstraintLayout() {

    }

    LazyRow() {

    }
}

@Composable
fun ScrollableForecastItem(item: TimeBasedForecast) {

}

@Composable
fun ShimmerForecast() {

}