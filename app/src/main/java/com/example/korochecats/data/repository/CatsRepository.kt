package com.example.korochecats.data.repository

import com.example.korochecats.api.CatsApi
import com.example.korochecats.data.model.CatImageResponse

interface CatsRepository {
    suspend fun getCatsImageList(): List<CatImageResponse>
}

class NetworkCatsRepository(private val catsApiObject: CatsApi) : CatsRepository {
    override suspend fun getCatsImageList() = catsApiObject.getCatsImageList()
}