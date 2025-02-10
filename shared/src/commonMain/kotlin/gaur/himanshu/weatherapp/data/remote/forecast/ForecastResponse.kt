package gaur.himanshu.weatherapp.data.remote.forecast

//http://api.openweathermap.org/data/2.5/forecast?lat=55.75&lon=37.61&appid=9c578f0523a6a83882f795be91d89251
data class ForecastResponse(
    val list: List<ForecastDTO>,
)