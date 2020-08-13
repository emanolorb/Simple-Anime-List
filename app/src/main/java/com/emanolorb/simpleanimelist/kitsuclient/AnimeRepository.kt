package com.emanolorb.simpleanimelist.kitsuclient

import AnimeHomeRequest
import AnimeModel
import androidx.lifecycle.MutableLiveData
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeRepository {
    var animeApiService: KitsuApiService? = null
    var animeClient: AnimeClient? =null
    private var animeList: MutableLiveData<List<AnimeModel>>? = null
    private var mangaList: MutableLiveData<List<AnimeModel>>? = null

    init {
        animeClient = AnimeClient.instance
        animeApiService = animeClient?.getAnimeApiService()
        // animeList = getAnimeList()
    }
    fun getAnimeList() : MutableLiveData<List<AnimeModel>>?{
        if (animeList==null){
            animeList = MutableLiveData<List<AnimeModel>>()
        }

        val call : Call<AnimeHomeRequest> = animeApiService!!.getAnimeList()
        call.enqueue(object : Callback<AnimeHomeRequest> {
            override fun onFailure(call: Call<AnimeHomeRequest>, t: Throwable) {
                debug_print("error----------------------------------")
                debug_print(call.toString())
                debug_print(t.toString())            }
            override fun onResponse(call: Call<AnimeHomeRequest>, response: Response<AnimeHomeRequest>) {
                if (response.isSuccessful){
                    animeList?.value = response.body()?.data
                }
            }
        })
        return animeList
    }
    fun getMangaList() : MutableLiveData<List<AnimeModel>>?{
        if (mangaList==null){
            mangaList = MutableLiveData<List<AnimeModel>>()
        }

        val call : Call<AnimeHomeRequest> = animeApiService!!.getMangaList()
        call.enqueue(object : Callback<AnimeHomeRequest> {
            override fun onFailure(call: Call<AnimeHomeRequest>, t: Throwable) {
                debug_print("error----------------------------------")
                debug_print(call.toString())
                debug_print(t.toString())            }
            override fun onResponse(call: Call<AnimeHomeRequest>, response: Response<AnimeHomeRequest>) {
                if (response.isSuccessful){
                    mangaList?.value = response.body()?.data
                }
            }
        })
        return mangaList
    }
}