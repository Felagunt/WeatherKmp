package gaur.himanshu.weatherapp.domain.repository

import gaur.himanshu.weatherapp.core.domain.DataError
import gaur.himanshu.weatherapp.core.domain.Result
import gaur.himanshu.weatherapp.domain.model.Forecast
import gaur.himanshu.weatherapp.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getCurrentWeatherInfo(lat: Double, long: Double): Weather

    suspend fun getForecastInfo(lat: Double, long: Double): List<Forecast>
}