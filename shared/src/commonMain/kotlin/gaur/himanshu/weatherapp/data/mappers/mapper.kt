package gaur.himanshu.weatherapp.data.mappers

import gaur.himanshu.weatherapp.data.remote.WeatherResponse
import gaur.himanshu.weatherapp.data.remote.forecast.ForecastResponse
import gaur.himanshu.weatherapp.domain.model.Forecast
import gaur.himanshu.weatherapp.domain.model.Weather

fun WeatherResponse.toWeather(): Weather {
    return Weather(
        name = name,
        temperature = this.main.temp.minus(273).toString(),
        iconUrl =  getImageUrl(this.weather.first().icon)
    )
}

fun ForecastResponse.toForecast(): List<Forecast> {
    return this.list.map {forecast ->
        Forecast(
        date = formatDate(forecast.dt.toLong()),
        temperature = forecast.main.temp.minus(273).toString(),
        iconUrl = getImageUrl(forecast.weather.first().icon)
        )
    }
}

expect fun formatDate(millis: Long): String

fun getImageUrl(iconId: String) = "https://openweathermap.org/img/wn/$iconId@2x.png"