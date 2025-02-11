package gaur.himanshu.weatherapp.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skydoves.landscapist.glide.GlideImage
import gaur.himanshu.weatherapp.presentation.weather.WeatherState
import gaur.himanshu.weatherapp.presentation.weather.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreenRoot(
    viewModel: WeatherViewModel = koinViewModel<WeatherViewModel>()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    WeatherScreen(
        state = state
    )
}

@Composable
fun WeatherScreen(
    state: WeatherState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.errorMsg?.let {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.errorMsg!!, style = MaterialTheme.typography.titleMedium)
            }
        }
        Spacer(modifier = Modifier.height(64.dp))
        state.weather?.let { weather ->
            com.skydoves.landscapist.glide.GlideImage(imageModel = weather.iconUrl,
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp))
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = weather.temperature.plus("  C"),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = weather.name, style = MaterialTheme.typography.headlineMedium
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        state.forecast?.let { list ->
            LazyColumn {
                item {
                    Text(
                        text = "Forecast: ",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                items(list) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.onSurfaceVariant,
                                shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        Text(text = it.date)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = it.temperature.plus(" C"))
                        Spacer(modifier = Modifier.weight(1f))
                        com.skydoves.landscapist.glide.GlideImage(
                            imageModel = it.iconUrl,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }
        }

    }
}
