package com.example.diworkshop.models.entities.anime

import com.google.gson.annotations.SerializedName

class AnimeFactInfo(
    @SerializedName("fact_id")
    val id: Int,

    @SerializedName("fact")
    val fact: String
)