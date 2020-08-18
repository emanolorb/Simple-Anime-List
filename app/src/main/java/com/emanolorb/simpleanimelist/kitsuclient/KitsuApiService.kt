package com.emanolorb.simpleanimelist.kitsuclient
import AnimeHomeRequest
import com.emanolorb.simpleanimelist.models.anime.requestDetail.DetailRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KitsuApiService {
    @GET("trending/anime")
    fun getAnimeList(): Call<AnimeHomeRequest>

    @GET("trending/manga")
    fun getMangaList(): Call<AnimeHomeRequest>


    @GET("{path}")
    fun getDetail(@Path(value = "path", encoded = true) id: String?): Call<DetailRequestModel>
}