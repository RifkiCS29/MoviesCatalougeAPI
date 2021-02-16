package com.rifki.jetpackpro.mymovies.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity (
        var id: Int,
        var posterPath: String,
        var title: String,
        var voteAverage: Double
): Parcelable