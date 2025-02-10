package gaur.himanshu.weatherapp.data.remote


//http://api.openweathermap.org/data/2.5/weather?lat=55.75&lon=37.61&appid=9c578f0523a6a83882f795be91d89251
data class WeatherResponse(

    val main: MainDTO,
    val name: String,
    val sys: SysDTO,
    val weather: List<WeatherDTO>,
)