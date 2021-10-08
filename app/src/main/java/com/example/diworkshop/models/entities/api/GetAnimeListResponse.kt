package com.example.diworkshop.models.entities.api

import com.example.diworkshop.models.entities.anime.AnimeInfo
import com.google.gson.annotations.SerializedName

class GetAnimeListResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("data")
    val data: List<AnimeInfo>
)