package com.junsu.movie.presentation.main.view

import android.os.Bundle
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.data.api.RetrofitClient
import com.junsu.movie.presentation.base.BaseActivity
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }
}