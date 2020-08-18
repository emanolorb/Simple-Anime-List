package com.emanolorb.simpleanimelist.ui.trendingList

import AnimeModel
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emanolorb.simpleanimelist.R
import com.emanolorb.simpleanimelist.common.MyApp
import com.emanolorb.simpleanimelist.common.Tools.debug_print
import com.emanolorb.simpleanimelist.data.AnimeListViewModel
import com.emanolorb.simpleanimelist.ui.DetailActivity

class AnimeTrendingFragment : Fragment() {

    private var columnCount = 2

    private var animeList: List<AnimeModel> = ArrayList()
    lateinit var animeListViewModel: AnimeListViewModel // model
    lateinit var animeTAdapter: MyanimeTrendingRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_anime_trending_list, container, false)
        // initialice el viewModel
        animeListViewModel = ViewModelProvider(this).get(AnimeListViewModel::class.java)
        // adapter

        animeTAdapter = MyanimeTrendingRecyclerViewAdapter(animeList, { partItem : AnimeModel -> partItemClicked(partItem) })


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = animeTAdapter
            }
        }
        //observer

        animeListViewModel.getAnimeList().observe(viewLifecycleOwner, Observer {
            animeTAdapter.setData(it)
        })


        return view
    }

    private fun partItemClicked(partItem : AnimeModel) {
        // debug_print(partItem.toString(), "item")
        // Launch second activity, pass part ID as string parameter
        val showDetailActivityIntent = Intent(MyApp.instance, DetailActivity::class.java)
        showDetailActivityIntent.putExtra("Detail", "anime/${partItem.id}")
        startActivity(showDetailActivityIntent)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            AnimeTrendingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
