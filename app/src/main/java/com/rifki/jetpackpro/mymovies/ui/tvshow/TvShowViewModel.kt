package com.rifki.jetpackpro.mymovies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {

    fun getTvShows(): LiveData<List<TvShowEntity>> = movieAppRepository.getTvShows()
}