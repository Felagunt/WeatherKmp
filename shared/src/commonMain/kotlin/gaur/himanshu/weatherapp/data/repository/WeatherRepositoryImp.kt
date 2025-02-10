package gaur.himanshu.weatherapp.data.repository

import gaur.himanshu.weatherapp.core.domain.DataError
import gaur.himanshu.weatherapp.core.domain.Result
import gaur.himanshu.weatherapp.data.datasource.remote.ApiService
import gaur.himanshu.weatherapp.data.mappers.toForecast
import gaur.himanshu.weatherapp.data.mappers.toWeather
import gaur.himanshu.weatherapp.domain.model.Forecast
import gaur.himanshu.weatherapp.domain.model.Weather
import gaur.himanshu.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow


class WeatherRepositoryImp(private val apiService: ApiService): WeatherRepository {

    override suspend fun getCurrentWeatherInfo(lat: Double, long: Double):
            Weather {
        return apiService
            .currentWeatherInfo(lat, long).toWeather()
    }

    override suspend fun getForecastInfo(lat: Double, long: Double): List<Forecast> {
        return apiService.forecastInfo(lat, long).toForecast()
    }
}