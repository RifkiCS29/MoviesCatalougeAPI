package com.rifki.jetpackpro.mymovies.data.source.local.entity

data class DetailMovieEntity (
        var title: String,
        var backdropPath: String,
        var genres: List<String>,
        var id: Int,
        var overview: String,
        var runtime: Int,
        var posterPath: String,
        var releaseDate: String,
        var voteAverage: Double,
        var tagline: String? = "",
)