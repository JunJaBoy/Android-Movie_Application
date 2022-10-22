package com.junsu.movie.presentation.main.fragment.movie.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.data.api.RetrofitClient
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

class MovieFragment(override var parentActivity: AppCompatActivity) :
    BaseFragment<FragmentMovieBinding>(
        R.layout.fragment_movie
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(parentActivity, "", Toast.LENGTH_SHORT).show()
        getDailyBoxOffice()
    }

    fun getDailyBoxOffice() {
        val rt = RetrofitClient.getRetrofitClient()
        val movieService = MovieService()
        movieService.getDailyBoxOfficeList("20221020")
        println(movieService.toString())
    }

    override fun observeEvent() {}
}