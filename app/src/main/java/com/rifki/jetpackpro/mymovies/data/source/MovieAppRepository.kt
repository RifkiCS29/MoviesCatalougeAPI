package com.rifki.jetpackpro.mymovies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailMovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailTvShowEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.MovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.TvShowEntity
import com.rifki.jetpackpro.mymovies.data.source.remote.RemoteDataSource
import com.rifki.jetpackpro.mymovies.data.source.remote.response.*

class MovieAppRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieAppDataSource {

    companion object {
        @Volatile

        private var instance: MovieAppRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieAppRepository =
                instance ?: synchronized(this) {
                    instance ?: MovieAppRepository(remoteData)
                }
    }

    override fun getMovies(): LiveData<List<MovieEntity>> {
        val resultsMovieItem = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movieResponses: List<ResultsMovieItem>) {
                val listMovies = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    with(response)  {
                        val movie = MovieEntity(
                            id,
                            posterPath,
                            title,
                            voteAverage
                        )
                        listMovies.add(movie)
                    }
                }
                resultsMovieItem.postValue(listMovies)
            }
        })
        return resultsMovieItem
    }

    override fun getTvShows(): LiveData<List<TvShowEntity>> {
        val resultsTvShowItem = MutableLiveData<List<TvShowEntity>>()

        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsReceived(tvShowResponses: List<ResultsTvShowItem>) {
                val listTvShows = ArrayList<TvShowEntity>()
                for (response in tvShowResponses) {
                    with(response) {
                        val tvShow = TvShowEntity(
                            id,
                            posterPath,
                            name,
                            voteAverage
                        )
                        listTvShows.add(tvShow)
                    }
                }
                resultsTvShowItem.postValue(listTvShows)
            }
        })
        return resultsTvShowItem
    }

    override fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity> {
        val detailMovieItemResult = MutableLiveData<DetailMovieEntity>()

        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse) {
                with(detailMovieResponse) {
                    val listGenres = ArrayList<String>()

                    for (genre in genres) {
                        listGenres.add(genre.name)
                    }

                    val detailMovieResult = DetailMovieEntity(
                            title,
                            backdropPath,
                            genres = listGenres,
                            id,
                            overview,
                            runtime,
                            posterPath,
                            releaseDate,
                            voteAverage
                    )
                    detailMovieItemResult.postValue(detailMovieResult)
                }
            }
        })
        return detailMovieItemResult
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity> {
        val detailTvShowItemResult = MutableLiveData<DetailTvShowEntity>()

        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(detailTvShowResponse: DetailTvShowResponse) {
                with(detailTvShowResponse) {
                    val listGenres = ArrayList<String>()

                    for (genre in genres) {
                        listGenres.add(genre.name)
                    }

                    val detailTvShowResult = DetailTvShowEntity(
                            backdropPath,
                            genres = listGenres,
                            id,
                            firstAirDate,
                            overview,
                            posterPath,
                            voteAverage,
                            name,
                            tagline
                    )
                    detailTvShowItemResult.postValue(detailTvShowResult)
                }
            }
        })
        return detailTvShowItemResult
    }
}