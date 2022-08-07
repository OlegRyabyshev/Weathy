@file:OptIn(ExperimentalComposeUiApi::class)

package com.sbery.weathy.presentation.screens.weather

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.sbery.weathy.R
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.model.domain.WeatherForecast.DailyForecast
import com.sbery.weathy.model.domain.WeatherForecast.HourlyForecast

@Composable
fun WeatherScreen(weatherViewModel: WeatherViewModel = hiltViewModel()) {
    weatherViewModel.loadWeatherForecast("55", "37")

    when (val state = weatherViewModel.weatherUiState.value) {
        is WeatherUiState.Forecast -> ForecastScreen(state.weatherForecast)
        is WeatherUiState.Loading -> ShimmerForecastScreen()
        is WeatherUiState.Error -> ErrorAlert(state.error)
    }
}

@Composable
fun ForecastScreen(forecast: WeatherForecast) {
    val (temp, feelsTemp) = createRefs()

    Surface(color = Color.White) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//            Text(text = forecast.temp){
//                constrain()
//            }
        }

        LazyRow() {

        }
    }
}

@Composable
fun ShimmerForecastScreen() {

}

@Composable
fun HourlyScrollableForecast(hourlyList: List<HourlyForecast>) {
    LazyRow(){
//        items = hourlyList
    }
}

@Composable
fun DailyScrollableForecast(dailyList: List<DailyForecast>) {
    LazyColumn() {
//        items(dailyList)
    }
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
            22,
            26,
            listOf(
                HourlyForecast(
                    123,
                    R.drawable.wc_cloud,
                    36
                )
            ),
            listOf(
                DailyForecast(
                    123,
                    R.drawable.wc_lightning,
                    35,
                    -23
                )
            )
        )
    )
}