package com.rifki.jetpackpro.mymovies.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rifki.jetpackpro.mymovies.R
import com.rifki.jetpackpro.mymovies.databinding.ActivityDetailMovieBinding
import com.rifki.jetpackpro.mymovies.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailMovie

        setContentView(activityDetailMovieBinding.root)

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getInt(EXTRA_MOVIE)
            if (id != null) {
                Log.d("Detail", "id: $id")
            }
        }

    }
}