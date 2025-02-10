package gaur.himanshu.weatherapp.presentation.weather

import gaur.himanshu.weatherapp.domain.model.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null
    )