package gaur.himanshu.weatherapp.di

import androidx.lifecycle.viewmodel.compose.viewModel
import gaur.himanshu.weatherapp.data.datasource.remote.ApiService
import gaur.himanshu.weatherapp.data.datasource.remote.KtorClient
import gaur.himanshu.weatherapp.data.repository.WeatherRepositoryImp
import gaur.himanshu.weatherapp.domain.repository.WeatherRepository
import gaur.himanshu.weatherapp.getPlatform
import gaur.himanshu.weatherapp.presentation.weather.WeatherViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factory {
        KtorClient.client
    }
    factory <ApiService> { ApiService(get ())  }
    singleOf(::ApiService)
    singleOf(::WeatherRepositoryImp).bind<WeatherRepository>()

    viewModelOf(::WeatherViewModel)
    //factory { getPlatform(this) }
}