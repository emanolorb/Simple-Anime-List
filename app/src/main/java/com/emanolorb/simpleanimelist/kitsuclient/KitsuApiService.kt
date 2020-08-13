package com.emanolorb.simpleanimelist.kitsuclient
import AnimeHomeRequest
import retrofit2.Call
import retrofit2.http.GET

interface KitsuApiService {
    @GET("trending/anime")
    fun getAnimeList(): Call<AnimeHomeRequest>

    @GET("trending/manga")
    fun getMangaList(): Call<AnimeHomeRequest>
}