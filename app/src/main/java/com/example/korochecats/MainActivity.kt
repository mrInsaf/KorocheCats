package com.example.korochecats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.korochecats.api.fake.FakeApiObject
import com.example.korochecats.api.network.NetworkApiObject
import com.example.korochecats.data.repository.NetworkCatsRepository
import com.example.korochecats.ui.screens.CatsMainScreen
import com.example.korochecats.ui.theme.KorocheCatsTheme
import com.example.korochecats.ui.viewModel.CatsViewModel
import com.example.korochecats.ui.viewModel.CatsViewModelFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val catsRepository = NetworkCatsRepository(NetworkApiObject)
        val catsViewModel: CatsViewModel by viewModels {
            CatsViewModelFactory(catsRepository)
        }
        try {
            catsViewModel.getCatsImageList()
        }
        catch (e: Exception) {
            println(e)
        }
        setContent {
            KorocheCatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val uiState = catsViewModel.uiState
                    if (uiState.catImageList.isEmpty()) {
                        Text(text = "Загрузка...")
                    } else {
                        // Отображаем изображения
                        CatsMainScreen(catImageResponseList = uiState.catImageList)
                    }

                }
            }
        }
    }
}

