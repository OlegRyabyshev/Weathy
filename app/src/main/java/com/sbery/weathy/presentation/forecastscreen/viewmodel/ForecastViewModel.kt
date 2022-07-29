package com.sbery.weathy.presentation.forecastscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sbery.weathy.domain.interactor.WeatherInteractor
import com.sbery.weathy.model.domain.WeatherForecast
import com.sbery.weathy.util.livedata.SingleLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/**
 * ViewModel для экрана списка категорий в ShopInSbol.
 *
 * @property interactor интерактор получения данных в ShopInSbol.
 *
 * @author Рябышев Олег on 11/07/2022
 */
internal class ShopCategoryViewModel(
    private val interactor: WeatherInteractor
) : ViewModel() {

    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData
    private var _loadingLiveData = MutableLiveData<Boolean>()

    val errorLiveData: LiveData<Boolean>
        get() = _errorLiveData
    private var _errorLiveData = MutableLiveData<Boolean>()

    val forecastLiveData: LiveData<WeatherForecast>
        get() = _forecastLiveData
    private var _forecastLiveData = SingleLiveData<WeatherForecast>()

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _errorLiveData.value = true
    }

    fun loadWeatherForecast(lat: String, lon: String) {
        viewModelScope.launch(exceptionHandler) {
            _loadingLiveData.value = true
            val weatherForecast = interactor.getWeatherForecast(lat, lon)
            _forecastLiveData.value = weatherForecast
            _loadingLiveData.value = false
        }
    }
}
