package gaur.himanshu.weatherapp

import gaur.himanshu.weatherapp.di.dataModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class KoinApp: KoinComponent {
    fun Main() {
        startKoin {
            modules(dataModule)
        }
    }
}