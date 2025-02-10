package gaur.himanshu.weatherapp.data.remote


data class WeatherDTO(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)