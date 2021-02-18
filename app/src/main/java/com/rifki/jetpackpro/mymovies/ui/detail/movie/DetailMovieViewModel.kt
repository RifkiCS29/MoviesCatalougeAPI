package com.rifki.jetpackpro.mymovies.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailMovieEntity

class DetailMovieViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): LiveData<DetailMovieEntity> = movieAppRepository.getDetailMovie(movieId)
}