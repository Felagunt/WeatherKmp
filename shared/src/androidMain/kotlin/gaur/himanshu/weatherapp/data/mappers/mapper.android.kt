package gaur.himanshu.weatherapp.data.mappers

import java.text.SimpleDateFormat

actual fun formatDate(millis: Long): String {

    val formatter = SimpleDateFormat("dd MMM hh:mm a")
    return formatter.format(millis.times(1000).toDouble())
}