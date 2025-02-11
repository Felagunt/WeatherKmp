package gaur.himanshu.weatherapp.data.datasource.remote

import gaur.himanshu.weatherapp.data.remote.WeatherResponse
import gaur.himanshu.weatherapp.data.remote.forecast.ForecastResponse

interface RemoteDataSource {
    suspend fun currentWeatherInfo(lat: Double, long: Double): WeatherResponse
    suspend fun forecastInfo(lat: Double, long: Double):ForecastResponse
}