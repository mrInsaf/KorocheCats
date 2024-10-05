package com.example.korochecats.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.korochecats.data.fake.fakeImageList
import com.example.korochecats.data.model.CatImageResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatsMainScreen(
    catImageResponseList: List<CatImageResponse>
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Короче cats") }) },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp)
            ) {
                items(catImageResponseList) { image ->
                    CatImage(
                        imageUrl = image.url
                    )
                }
            }
        }
    }
}

@Composable
fun CatImage(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Cat Image",
        contentScale = ContentScale.Crop, // Вы можете выбрать другой стиль: Fit, FillBounds, и т.д.
        modifier = modifier
    )
}

@Preview
@Composable
fun CatsMainScreenPreview() {
    CatsMainScreen(
        fakeImageList
    )
}