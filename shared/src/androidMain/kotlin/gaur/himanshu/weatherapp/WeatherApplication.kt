package gaur.himanshu.weatherapp

import android.app.Application
import gaur.himanshu.weatherapp.di.dataModule
import org.koin.core.context.startKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(dataModule) }
    }
}