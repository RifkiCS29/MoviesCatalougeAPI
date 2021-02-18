package com.rifki.jetpackpro.mymovies.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rifki.jetpackpro.mymovies.R
import com.rifki.jetpackpro.mymovies.data.source.local.entity.TvShowEntity
import com.rifki.jetpackpro.mymovies.databinding.ItemMovieTvShowBinding
import com.rifki.jetpackpro.mymovies.ui.detail.tvshow.DetailTvShowActivity
import com.squareup.picasso.Picasso

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>){
        if (tvShows.isNullOrEmpty()) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieTvShowBinding = ItemMovieTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemMovieTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShows[position])
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvShowViewHolder(private val binding: ItemMovieTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvRating.text = tvShow.voteAverage.toString()

                Picasso.get()
                        .load("https://image.tmdb.org/t/p/w185${tvShow.posterPath}")
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.id)
                    }
                    itemContainer.context.startActivity(intent)
                }
            }
        }
    }
}