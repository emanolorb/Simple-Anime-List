package com.emanolorb.simpleanimelist.data

import AnimeModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.kitsuclient.AnimeRepository

class AnimeListViewModel:ViewModel() {
    private var  animeRepository:AnimeRepository
    var animeListLivedata: LiveData<List<AnimeModel>>

    init {
        animeRepository = AnimeRepository()
        animeListLivedata = animeRepository.returnAnimeList()!!
    }

    fun getAnimeList(): LiveData<List<AnimeModel>>{
        return animeListLivedata
    }
}