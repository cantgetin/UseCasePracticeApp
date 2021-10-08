package com.example.diworkshop.utils

import com.example.diworkshop.API_URL
import com.example.diworkshop.sources.api.AnimeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeServiceBuilder {
    fun build(): AnimeService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeService::class.java)
    }
}