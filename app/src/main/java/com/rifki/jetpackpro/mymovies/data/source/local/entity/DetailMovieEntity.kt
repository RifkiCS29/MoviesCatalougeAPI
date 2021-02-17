package com.rifki.jetpackpro.mymovies.data.source.local.entity

import com.google.gson.annotations.SerializedName
import com.rifki.jetpackpro.mymovies.data.source.remote.response.GenresMovieItem

data class DetailMovieEntity (
        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("backdrop_path")
        val backdropPath: String,

        @field:SerializedName("genres")
        val genres: List<String>,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("runtime")
        val runtime: Int,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("release_date")
        val releaseDate: String,

        @field:SerializedName("vote_average")
        val voteAverage: Double,

        @field:SerializedName("tagline")
        val tagline: String? = "",
)