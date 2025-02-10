package gaur.himanshu.weatherapp.data.remote.forecast

import gaur.himanshu.weatherapp.data.remote.MainDTO
import gaur.himanshu.weatherapp.data.remote.SysDTO
import gaur.himanshu.weatherapp.data.remote.WeatherDTO

data class ForecastDTO(
    val dt: Int,
    val main: MainDTO,
    val sys: SysDTO,
    val weather: List<WeatherDTO>,
)