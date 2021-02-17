package com.rifki.jetpackpro.mymovies.di

import android.content.Context
import com.rifki.jetpackpro.mymovies.data.source.MovieAppRepository
import com.rifki.jetpackpro.mymovies.data.source.remote.RemoteDataSource

object Injection {

    fun provideRepository(context: Context): MovieAppRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieAppRepository.getInstance(remoteDataSource)
    }
}