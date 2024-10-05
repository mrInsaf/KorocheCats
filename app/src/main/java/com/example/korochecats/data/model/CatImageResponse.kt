package com.example.korochecats.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    val id: String,
    val url: String,
    val breeds: List<Breed> = emptyList() // Список пород, может быть пустым
)

@Serializable
data class Breed(
    val id: String,
    val name: String
)
