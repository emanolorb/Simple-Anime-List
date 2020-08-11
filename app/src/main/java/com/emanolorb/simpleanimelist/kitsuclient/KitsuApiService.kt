package com.emanolorb.simpleanimelist.kitsuclient
import AnimeHomeRequest
import retrofit2.Call
import retrofit2.http.GET

interface KitsuApiService {
    @GET("anime")
    fun getAnimeList(): Call<AnimeHomeRequest>
}