package com.emanolorb.simpleanimelist

import AnimeModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.data.AnimeListViewModel
import com.emanolorb.simpleanimelist.ui.HomeTabActivity

class MainActivity : AppCompatActivity() {
    private lateinit var animeListViewModel: AnimeListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
    }

    override fun onResume() {
        super.onResume()
        //setUpView()
    }
    fun setUpView(){
        animeListViewModel = ViewModelProvider(this).get(AnimeListViewModel::class.java)
        // Create the observer which updates the UI.
        val animeListObserver = Observer<List<AnimeModel>> {
            if (it != null){
                setList(it)
            }
        }
        // Observer de las peliculas
        animeListViewModel.getAnimeList().observe(this, animeListObserver)
    }
    fun setList(animeList:List<AnimeModel>){
        debug_print(animeList.toString(),"Anime List")
    }
}
