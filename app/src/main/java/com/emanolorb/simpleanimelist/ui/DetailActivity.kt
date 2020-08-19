package com.emanolorb.simpleanimelist.ui

import AnimeModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.emanolorb.simpleanimelist.R
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.data.DetailViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

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
        ivCoverDA.load(detail.attributes.posterImage.medium){
            //crossfade(true)
            //placeholder(R.drawable.ic_cinema_color)
        }
        tvTitleDA.text = detail.attributes.titles.en_jp
        tvTypeDA.text = "${getString(R.string.detailTypeDA)}: ${detail.type.capitalize()}"
        tvStatusDA.text = "${getString(R.string.detailStatusDA)}: ${detail.attributes.status}"
        tvRatingRankDA.text = "${getString(R.string.detailratingRankDA)}: ${detail.attributes.ratingRank}"
        tvStartDA.text = "${getString(R.string.detailStartingDateDA)}: ${detail.attributes.startDate}"
        tvSynopsisDA.text = "${getString(R.string.detailSynopsisDA)}: ${detail.attributes.synopsis}"
        debug_print(detail, "detail")
    }

}
