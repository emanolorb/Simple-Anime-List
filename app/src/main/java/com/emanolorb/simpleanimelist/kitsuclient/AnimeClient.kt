package com.emanolorb.simpleanimelist.kitsuclient

import com.emanolorb.simpleanimelist.common.Constants
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeClient {
    private val animeApiService: KitsuApiService
    private val retrofit:Retrofit

    // este companion es para regresar una instancia del mismo si no existe la crea y si existe regresa la existente
    companion object{
        var instance : AnimeClient? = null
            get() {
                if (field==null){
                    instance = AnimeClient()
                }
                return field
            }
    }

    init {
        var builderOKHTTTP = OkHttpClient.Builder()
        // add interceptor aqui

        var clientOk = builderOKHTTTP.build()
        // construimos objeto retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.KITSU_API_URL)
            .client(clientOk)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        animeApiService = retrofit.create(KitsuApiService::class.java)
    }

    fun getAnimeApiService() = animeApiService
}