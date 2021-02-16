package com.rifki.jetpackpro.mymovies.ui.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.rifki.jetpackpro.mymovies.R
import com.rifki.jetpackpro.mymovies.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logoMovie.animation = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        binding.myMovies.animation = AnimationUtils.loadAnimation(this, R.anim.bottom_anim)
    }
}