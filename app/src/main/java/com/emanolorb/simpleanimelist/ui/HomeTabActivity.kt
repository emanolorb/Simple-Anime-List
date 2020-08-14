package com.emanolorb.simpleanimelist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.emanolorb.simpleanimelist.R
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.ui.tabconfig.ViewPagerTabsAdapter
import com.emanolorb.simpleanimelist.ui.trendingList.AnimeTrendingFragment
import com.emanolorb.simpleanimelist.ui.trendingList.MangaTrendingFragment
import kotlinx.android.synthetic.main.activity_home_tab.*

class HomeTabActivity : AppCompatActivity() {
    var toolbar : Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tab)
        setToolBar()
        setUpTabs()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.imGeneralItem -> {
                debug_print("Item menu")
                Toast.makeText(this, "You are beatifull!!", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setToolBar(){
        // Toolbar settings
        toolbar = findViewById(R.id.tbHomeTab)
        toolbar?.title = "Trending App"
        setSupportActionBar(toolbar)
    }
    fun setUpTabs(){
        val adapter = ViewPagerTabsAdapter(supportFragmentManager)
        // add fragments
        adapter.addFragment(AnimeTrendingFragment(), "Anime Trending")
        adapter.addFragment(MangaTrendingFragment(), "Manga Trending")

        vpHomeTab.adapter = adapter
        tlHomeTab.setupWithViewPager(vpHomeTab)
        // add icons to fragments
        tlHomeTab.getTabAt(0)!!.setIcon(R.drawable.ic_grinning)
        tlHomeTab.getTabAt(1)!!.setIcon(R.drawable.ic_smiling)
    }

}
