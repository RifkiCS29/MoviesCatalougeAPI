package com.rifki.jetpackpro.mymovies.utils

import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailMovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.DetailTvShowEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.MovieEntity
import com.rifki.jetpackpro.mymovies.data.source.local.entity.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        return listOf(
                MovieEntity(
                        "581389",
                        "/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg4",
                        "Space Sweepers",
                        7.3
                ),
                MovieEntity(
                        "464052",
                        "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "Wonder Woman 1984",
                        6.9
                ),
                MovieEntity(
                        "587996",
                        "/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg",
                        "Below Zero",
                        6.4
                ),
                MovieEntity(
                        "602269",
                        "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                        "The Little Things",
                        6.4
                )

        )
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        return listOf(
                TvShowEntity(
                        "85271",
                        "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                        "WandaVision",
                        8.4
                ),
                TvShowEntity(
                        "69050",
                        "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                        "Riverdale",
                        8.6
                ),
                TvShowEntity(
                        "71712",
                        "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "The Good Doctor",
                        8.6
                ),
                TvShowEntity(
                        "1416",
                        "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "Grey's Anatomy",
                        8.2
                )
        )
    }

    fun generateDetailMovie(): DetailMovieEntity {
        return DetailMovieEntity(
                "Space Sweepers",
                "/drulhSX7P5TQlEMQZ3JoXKSDEfz.jpg",
                listOf("Drama", "Fantasy", "Science Fiction"),
                581389,
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                136,
                "/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                "2021-02-05",
                7.3,
                "2092, the space sweep begins!"
        )
    }

    fun generateDetailTvShow(): DetailTvShowEntity {
        return DetailTvShowEntity(
                "/lOr9NKxh4vMweufMOUDJjJhCRHW.jpg",
                listOf("Sci-Fi & Fantasy", "Mystery", "Drama"),
                85271,
                "2021-01-15",
                "Disturbances on Halloween separate Wanda from Vision, who looks into anomalous activity in Westview.",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                8.4,
                "WandaVision",
                "Experience a new vision of reality."
        )
    }
}