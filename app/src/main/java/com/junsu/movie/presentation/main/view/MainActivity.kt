package com.junsu.movie.presentation.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.data.api.RetrofitClient
import com.junsu.movieapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDailyBoxOffice()
    }

    fun getDailyBoxOffice() {
        val rt = RetrofitClient.getRetrofitClient()
        val movieService = MovieService()
        movieService.getDailyBoxOfficeList("20221020")
        println(movieService.toString())
    }
}