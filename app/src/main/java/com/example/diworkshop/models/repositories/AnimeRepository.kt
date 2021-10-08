package com.example.diworkshop.models.repositories

import com.example.diworkshop.models.entities.anime.AnimeDetailInfo
import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.example.diworkshop.sources.api.AnimeService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api: AnimeService
) {
    suspend fun getAnimeList(): List<AnimeInfo> {
        return api.getAnimeList().data.toList()
    }

    suspend fun getAnimeDetailInfo(animeName: String): AnimeDetailInfo {
        val response = api.getAnimeDetailInfo(animeName)
        return AnimeDetailInfo(
            image = response.image,
            data = response.data
        )
    }
}