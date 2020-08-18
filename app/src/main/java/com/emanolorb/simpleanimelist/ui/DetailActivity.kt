package com.emanolorb.simpleanimelist.ui

import AnimeModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.simpleanimelist.R
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.data.DetailViewModel
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    lateinit var detailViewModel:DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpView()
    }
    fun setUpView(){
        val intentThatStartedThisActivity = intent
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        // Create the observer which updates the UI.
        val detailViewModelObserver = Observer<AnimeModel> {
            if (it != null){
                setdetails(it)
            }
        }

        if (intentThatStartedThisActivity.hasExtra("Detail")) {
            val detailId  = intentThatStartedThisActivity.getStringExtra("Detail")
            if (detailId != null) {
                // Observer de las peliculas
                debug_print(detailId,"detailID")
                detailViewModel.setMovieDetail(detailId)?.observe(this, detailViewModelObserver)
            }
        }
    }
    fun setdetails(detail:AnimeModel){
        debug_print(detail, "detail", true)
    }

}
