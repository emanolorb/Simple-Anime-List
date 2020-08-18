package com.emanolorb.simpleanimelist.data

import AnimeModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emanolorb.simpleanimelist.kitsuclient.AnimeRepository

class DetailViewModel: ViewModel() {


    private  var theMovieRepository: AnimeRepository = AnimeRepository()
    var movieDetail: MutableLiveData<AnimeModel>? = MutableLiveData()
    fun setMovieDetail(path: String): LiveData<AnimeModel>?{
        movieDetail = theMovieRepository.getDetail(path)
        return movieDetail
    }

}