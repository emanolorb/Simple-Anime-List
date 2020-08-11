package com.emanolorb.simpleanimelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emanolorb.simpleanimelist.ui.HomeTabActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, HomeTabActivity::class.java))
    }
}
