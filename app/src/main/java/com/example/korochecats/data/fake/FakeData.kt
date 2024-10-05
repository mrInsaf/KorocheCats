package com.example.korochecats.data.fake

import com.example.korochecats.data.model.Breed
import com.example.korochecats.data.model.CatImageResponse


val fakeImageList = listOf(
    CatImageResponse(
        id = "LSaDk6OjY",
        url = "https://cdn2.thecatapi.com/images/LSaDk6OjY.jpg",
        breeds = listOf(Breed(id = "beng", name = "Bengal")) // Пример с породой
    ),
    CatImageResponse(
        id = "8ciqdpaO5",
        url = "https://cdn2.thecatapi.com/images/8ciqdpaO5.jpg",
        breeds = listOf(Breed(id = "beng", name = "Bengal")) // Пример с породой
    )
)