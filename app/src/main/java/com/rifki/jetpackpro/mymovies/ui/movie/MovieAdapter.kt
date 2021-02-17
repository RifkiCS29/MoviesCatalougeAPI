package com.rifki.jetpackpro.mymovies.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rifki.jetpackpro.mymovies.R
import com.rifki.jetpackpro.mymovies.data.source.local.entity.MovieEntity
import com.rifki.jetpackpro.mymovies.databinding.ItemMovieTvShowBinding
import com.squareup.picasso.Picasso

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovies = ArrayList<MovieEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setMovies(movies: List<MovieEntity>){
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieTvShowBinding = ItemMovieTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieTvShowBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemMovieTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvTitle.isSelected = true
                tvTitle.isSingleLine = true
                tvRating.text = movie.voteAverage.toString()

                Picasso.get()
                        .load("https://image.tmdb.org/t/p/w185${movie.posterPath}")
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                        .into(imgPoster)

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(movie)
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieEntity)
    }
}