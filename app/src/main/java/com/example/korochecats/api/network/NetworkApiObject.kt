package com.example.korochecats.api.network

import com.example.korochecats.api.CatsApi
import com.example.korochecats.data.model.CatImageResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object NetworkApiObject : CatsApi {
    private const val API_KEY = "live_JqhfDGCncBO8P5it1MwWy7BnxbBy5EkxEVsBrzEPeRnKPFlN9JGNDjQXZsnniZwA"
    private const val IMAGES_LIMIT = 20

    private const val baseUrl = "https://api.thecatapi.com/v1/"

    private val json = Json {
        ignoreUnknownKeys = true // Игнорировать неизвестные ключи
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: CatsApi by lazy {
        retrofit.create(CatsApi::class.java)
    }

    override suspend fun getCatsImageList(limit: Int, apiKey: String): List<CatImageResponse> =
        retrofitService.getCatsImageList(
            apiKey = API_KEY,
            limit = IMAGES_LIMIT
        )
}