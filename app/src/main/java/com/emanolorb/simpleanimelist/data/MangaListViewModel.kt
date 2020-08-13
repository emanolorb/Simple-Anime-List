package com.emanolorb.simpleanimelist.data

import AnimeModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emanolorb.simpleanimelist.kitsuclient.AnimeRepository

class MangaListViewModel:ViewModel() {

    private var  animeRepository: AnimeRepository
    var animeListLivedata: LiveData<List<AnimeModel>>

    init {
        animeRepository = AnimeRepository()
        animeListLivedata = animeRepository.getMangaList()!!
    }

    fun getMangaList(): LiveData<List<AnimeModel>> {
        return animeListLivedata
    }
}