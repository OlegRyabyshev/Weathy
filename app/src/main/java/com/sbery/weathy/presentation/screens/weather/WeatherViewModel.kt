package com.sbery.weathy.presentation.screens.weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sbery.weathy.domain.interactor.WeatherInteractor
import com.sbery.weathy.model.domain.WeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val interactor: WeatherInteractor
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _weatherUiState.value = WeatherUiState.Error(throwable.message.toString())
    }

    val weatherUiState: State<WeatherUiState>
        get() = _weatherUiState
    private val _weatherUiState = mutableStateOf<WeatherUiState>(WeatherUiState.Loading)

    fun loadWeatherForecast(lat: Double, lon: Double) {
        viewModelScope.launch(exceptionHandler) {
            _weatherUiState.value = WeatherUiState.Loading
            val weatherForecast = interactor.getWeatherForecast(lat, lon)
            _weatherUiState.value = WeatherUiState.Forecast(weatherForecast)
        }
    }
}

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    class Error(val error: String) : WeatherUiState()
    class Forecast(val weatherForecast: WeatherForecast) : WeatherUiState()
}