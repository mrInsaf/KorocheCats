package com.example.korochecats.api.fake

import com.example.korochecats.api.CatsApi
import com.example.korochecats.data.fake.fakeImageList
import com.example.korochecats.data.model.CatImageResponse

object FakeApiObject : CatsApi {
    override suspend fun getCatsImageList(limit: Int, apiKey: String): List<CatImageResponse> =
        fakeImageList
}