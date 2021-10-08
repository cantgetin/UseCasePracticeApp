package com.example.diworkshop.sources.api

import com.example.diworkshop.models.entities.api.GetAnimeDetailInfoResponse
import com.example.diworkshop.models.entities.api.GetAnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
    @GET("/")
    suspend fun getAnimeList(): GetAnimeListResponse

    @GET("/{animeName}")
    suspend fun getAnimeDetailInfo(
        @Path("animeName") animeName: String
    ): GetAnimeDetailInfoResponse
}