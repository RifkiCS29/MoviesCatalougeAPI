package com.rifki.jetpackpro.mymovies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.local.entity.MovieEntity

class MovieViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = movieAppRepository.getMovies()
}