package gaur.himanshu.weatherapp.data.remote

data class SysDTO(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)