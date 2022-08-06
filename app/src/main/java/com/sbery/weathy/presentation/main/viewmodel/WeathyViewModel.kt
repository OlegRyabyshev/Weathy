package com.sbery.weathy.presentation.main.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sbery.weathy.domain.interactor.WeatherInteractor
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.util.livedata.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class WeathyViewModel @Inject constructor(
    private val interactor: WeatherInteractor
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _errorLiveData.value = throwable.message
    }

    val loadingState: State<Boolean>
        get() = _loadingLiveData
    private var _loadingLiveData: MutableState<Boolean> = mutableStateOf(true)

    val errorLiveData: LiveData<String>
        get() = _errorLiveData
    private var _errorLiveData = MutableLiveData<String>()

    val forecastLiveData: LiveData<WeatherForecast>
        get() = _forecastLiveData
    private var _forecastLiveData = SingleLiveData<WeatherForecast>()

//    fun loadWeatherForecast(lat: String, lon: String) {
//        viewModelScope.launch(exceptionHandler) {
//            _loadingLiveData.value = true
//
//            val weatherForecast = interactor.getWeatherForecast(lat, lon)
//            _forecastLiveData.value = weatherForecast
//
//            _loadingLiveData.value = false
//        }
//    }
}
