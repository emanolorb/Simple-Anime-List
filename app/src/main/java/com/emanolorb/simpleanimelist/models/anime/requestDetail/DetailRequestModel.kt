package com.emanolorb.simpleanimelist.models.anime.requestDetail

import AnimeModel
import com.google.gson.annotations.SerializedName

data class DetailRequestModel (
    @SerializedName("data") val data :AnimeModel
)