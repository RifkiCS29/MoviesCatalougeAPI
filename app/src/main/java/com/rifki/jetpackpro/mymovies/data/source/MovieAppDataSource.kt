package com.rifki.jetpackpro.mymovies.data.source

import androidx.lifecycle.LiveData
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailMovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailTvShowEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.MovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.TvShowEntity

interface MovieAppDataSource {

    fun getMovies(): LiveData<List<MovieEntity>>

    fun getTvShows(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity>

    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity>

}