package com.emanolorb.simpleanimelist.ui.trendingList

import AnimeModel
import android.content.Context
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
import com.emanolorb.simpleanimelist.common.Tools
import com.emanolorb.simpleanimelist.data.AnimeListViewModel
import com.emanolorb.simpleanimelist.data.MangaListViewModel


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [MangaTrendingFragment.OnListFragmentInteractionListener] interface.
 */
class MangaTrendingFragment : Fragment() {
    private var columnCount = 2
    private lateinit var mangaTAdapter:MyMangaTrendingRecyclerViewAdapter
    private var mangaList: List<AnimeModel> = ArrayList()
    lateinit var animeListViewModel: MangaListViewModel // model
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
        val view = inflater.inflate(R.layout.fragment_manga_trending_list, container, false)

        // set viewModel
        animeListViewModel = ViewModelProvider(this).get(MangaListViewModel::class.java)

        // set adapter

        mangaTAdapter = MyMangaTrendingRecyclerViewAdapter(mangaList, { partItem : AnimeModel -> partItemClicked(partItem) })



        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = mangaTAdapter
            }
        }

        //observer

        animeListViewModel.getMangaList().observe(viewLifecycleOwner, Observer {
            mangaTAdapter.setData(it)
        })



        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            MangaTrendingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private fun partItemClicked(partItem : AnimeModel) {
        Tools.debug_print(partItem.toString(), "item")
        // Launch second activity, pass part ID as string parameter
//        val showDetailActivityIntent = Intent(this, MovieDetailActivity::class.java)
//        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
//        startActivity(showDetailActivityIntent)
    }
}
