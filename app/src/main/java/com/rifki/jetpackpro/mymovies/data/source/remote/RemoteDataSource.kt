package com.rifki.jetpackpro.mymovies.data.source.remote

import android.util.Log
import com.rifki.jetpackpro.mymovies.BuildConfig
import com.rifki.jetpackpro.mymovies.api.ApiConfig
import com.rifki.jetpackpro.mymovies.data.source.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class RemoteDataSource {

    companion object {
        private const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource()
                }
    }

    fun getMovies(callback: LoadMoviesCallback) {
        //val client = ApiConfig.getApiService().getMovies(BuildConfig.TMDB_API_KEY)
        GlobalScope.launch(Dispatchers.IO) {
            val client = ApiConfig.getApiService().getMovies(BuildConfig.TMDB_API_KEY)
            val response = client.awaitResponse()
            if (response.isSuccessful) {
                response.body()?.results?.let { callback.onMoviesReceived(it) }
            } else {
                Log.d(TAG, "onFailure :${response.message()}" )
            }
        }
//        client.enqueue(object : Callback<MovieResponse> {
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                response.body()?.let { callback.onMoviesReceived(it.results) }
//
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                Log.d(TAG, "onFailure :${t.message}" )
//
//            }
//
//        })
    }

    fun getTvShows(callback: LoadTvShowsCallback) {
        val client = ApiConfig.getApiService().getTvShows(BuildConfig.TMDB_API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                response.body()?.results?.let { callback.onTvShowsReceived(it) }

            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )

            }
        })
    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        val client = ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.TMDB_API_KEY)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                response.body()?.let { callback.onDetailMovieReceived(it) }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
            }

        })
    }

    fun getDetailTvShow(tvShowId: Int, callback: LoadDetailTvShowCallback) {
        val client = ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.TMDB_API_KEY)
        client.enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(call: Call<DetailTvShowResponse>, response: Response<DetailTvShowResponse>) {
                response.body()?.let { callback.onDetailTvShowReceived(it) }
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}" )
            }

        })
    }

    interface LoadMoviesCallback {
        fun onMoviesReceived(movieResponses : List<ResultsMovieItem>)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsReceived(tvShowResponses: List<ResultsTvShowItem>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse)
    }
}