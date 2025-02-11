package gaur.himanshu.weatherapp.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gaur.himanshu.weatherapp.core.domain.DataError
import gaur.himanshu.weatherapp.core.domain.Error
import gaur.himanshu.weatherapp.core.domain.Result
import gaur.himanshu.weatherapp.core.domain.onError
import gaur.himanshu.weatherapp.core.domain.onSuccess
import gaur.himanshu.weatherapp.domain.model.Forecast
import gaur.himanshu.weatherapp.domain.model.Weather
import gaur.himanshu.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.onStart {
        getWeather(55.33, 39.10)
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private fun getData(lat: Double, lon: Double) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        getWeather(lat, lon)
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = error.toString(),
                        weather = null
                    )
                }
            }
            .onSuccess { result ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = null,
                        weather = result
                    )
                }
            }


        getForecastInfo(lat, lon)
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = error.toString(),
                        forecast = null
                    )
                }
            }
            .onSuccess { result ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = null,
                        forecast = result
                    )
                }
            }
    }

    private suspend fun getWeather(lat: Double, lon: Double): Result<Weather, Error> {

//        _state.update {
//            it.copy(
//                isLoading = true
//            )
//        }
//        weatherRepository.getCurrentWeatherInfo(lat,lon).let { result ->
//            when(result) {}
//        }

        return try {
            val response = weatherRepository.getCurrentWeatherInfo(lat, lon)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(DataError.Remote.UNKNOWN)
        }
    }

    private suspend fun getForecastInfo(lat: Double, lon: Double): Result<List<Forecast>, Error> {

        return try {
            val response = weatherRepository.getForecastInfo(lat, lon)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(DataError.Remote.UNKNOWN)
        }
    }
}