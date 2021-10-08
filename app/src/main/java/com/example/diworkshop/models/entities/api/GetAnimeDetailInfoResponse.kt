package com.example.diworkshop.models.entities.api

import com.example.diworkshop.models.entities.anime.AnimeFactInfo
import com.google.gson.annotations.SerializedName

class GetAnimeDetailInfoResponse(
    @SerializedName("anime_img")
    val image: String,

    @SerializedName("data")
    val data: List<AnimeFactInfo>
)