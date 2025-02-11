package gaur.himanshu.weatherapp.data.datasource.remote

import gaur.himanshu.weatherapp.data.remote.WeatherResponse
import gaur.himanshu.weatherapp.data.remote.forecast.ForecastResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

private const val APP_ID = "9c578f0523a6a83882f795be91d89251"

private const val BASE_URL = ""

class ApiService(val client: HttpClient): RemoteDataSource {

    override suspend fun currentWeatherInfo(lat: Double, long: Double): WeatherResponse {
        return client.get {
            url {
                host = "api.openweathermap.org"
                path("data/2.5/weather")
                parameters.append("lat", lat.toString())
                parameters.append("lon", long.toString())
                parameters.append("appid", APP_ID)
            }
        }.body<WeatherResponse>()
    }

    override suspend fun forecastInfo(lat: Double, long: Double): ForecastResponse {
        return client.get {
            url {
                host = "api.openweathermap.org"
                path("data/2.5/forecast")
                parameters.append("lat", lat.toString())
                parameters.append("lon", long.toString())
                parameters.append("appid", APP_ID)
            }
        }.body<ForecastResponse>()
    }
}