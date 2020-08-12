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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var animeListViewModel: AnimeListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
    }
    fun setUpView(){
    btGoTabs.setOnClickListener {
        startActivity(Intent(this, HomeTabActivity::class.java))
    }
    }

}
