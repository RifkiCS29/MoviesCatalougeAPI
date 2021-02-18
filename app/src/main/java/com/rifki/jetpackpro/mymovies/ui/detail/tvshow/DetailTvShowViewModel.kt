package com.rifki.jetpackpro.mymovies.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailTvShowEntity

class DetailTvShowViewModel(private val movieAppRepository: MovieAppRepository): ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<DetailTvShowEntity> = movieAppRepository.getDetailTvShow(tvShowId)
}