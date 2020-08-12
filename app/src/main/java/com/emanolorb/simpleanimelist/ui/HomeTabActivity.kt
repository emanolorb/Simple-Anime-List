package com.emanolorb.simpleanimelist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emanolorb.simpleanimelist.R
import com.emanolorb.simpleanimelist.ui.tabconfig.ViewPagerTabsAdapter
import com.emanolorb.simpleanimelist.ui.trendingList.AnimeTrendingFragment
import kotlinx.android.synthetic.main.activity_home_tab.*

class HomeTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tab)
        setUpTabs()

    }

    fun setUpTabs(){
        val adapter = ViewPagerTabsAdapter(supportFragmentManager)
        // add fragments
        adapter.addFragment(AnimeTrendingFragment(), "")
        adapter.addFragment(AnimeTrendingFragment(), "")

        vpHomeTab.adapter = adapter
        tlHomeTab.setupWithViewPager(vpHomeTab)
        // add icons to fragments
        tlHomeTab.getTabAt(0)!!.setIcon(R.drawable.ic_grinning)
        tlHomeTab.getTabAt(1)!!.setIcon(R.drawable.ic_smiling)
    }

}
