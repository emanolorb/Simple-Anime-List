package com.emanolorb.simpleanimelist.ui.trendingList

import AnimeModel
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.emanolorb.simpleanimelist.R

import kotlinx.android.synthetic.main.fragment_manga_trending.view.*

class MyMangaTrendingRecyclerViewAdapter(
    private var mValues: List<AnimeModel>,
    val clickListener: (AnimeModel) -> Unit
) : RecyclerView.Adapter<MyMangaTrendingRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_manga_trending, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolder).bind(mValues[position], clickListener)
    }

    override fun getItemCount(): Int = mValues.size
    fun setData(animeList: List<AnimeModel>) {
        mValues = animeList
        notifyDataSetChanged() // para que actualice la data en el Layout
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        fun bind(part: AnimeModel, clickListener: (AnimeModel) -> Unit) {
            // here config layout
            mView.tvTitleFMT.text = part.attributes.titles.en_jp
            mView.tvStartDateFMT.text = part.attributes.startDate
            mView.ivAnimeCoverFMT.load(part.attributes.posterImage.medium){
                crossfade(true)
                placeholder(R.drawable.ic_smiling)
            }

            mView.setOnClickListener { clickListener(part)}
        }
    }
}
