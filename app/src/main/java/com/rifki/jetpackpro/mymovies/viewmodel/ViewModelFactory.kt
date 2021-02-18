package com.rifki.jetpackpro.mymovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.di.Injection
import com.rifki.jetpackpro.mymovies.ui.detail.movie.DetailMovieViewModel
import com.rifki.jetpackpro.mymovies.ui.detail.tvshow.DetailTvShowViewModel
import com.rifki.jetpackpro.mymovies.ui.movie.MovieViewModel
import com.rifki.jetpackpro.mymovies.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val movieAppRepository: MovieAppRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(movieAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}