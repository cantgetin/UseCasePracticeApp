package com.example.diworkshop.models.entities.anime

import com.google.gson.annotations.SerializedName

class AnimeInfo(
    @SerializedName("anime_id")
    val id: Int,

    @SerializedName("anime_name")
    val name: String,

    @SerializedName("anime_img")
    val image: String
)