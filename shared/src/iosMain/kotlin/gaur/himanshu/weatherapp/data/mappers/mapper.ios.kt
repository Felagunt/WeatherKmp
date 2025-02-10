package gaur.himanshu.weatherapp.data.mappers

import io.ktor.util.reflect.instanceOf
import kotlin.time.Duration

actual fun formatDate(millis: Long): String {
    val number = Duration.parse(millis.toString())
    val mim = number.inWholeMinutes
    val hr = number.inWholeHours
    val da = number.inWholeDays
    return ("day:$da hour: $hr minutes: $mim").toString()
}