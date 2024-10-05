package com.example.korochecats.api

import com.example.korochecats.data.model.CatImageResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsApi {
    @GET("images/search")
    suspend fun getCatsImageList(
        @Query("limit") limit: Int = 10,
        @Header("x-api-key") apiKey: String = "live_JqhfDGCncBO8P5it1MwWy7BnxbBy5EkxEVsBrzEPeRnKPFlN9JGNDjQXZsnniZwA"
    ): List<CatImageResponse>
}


