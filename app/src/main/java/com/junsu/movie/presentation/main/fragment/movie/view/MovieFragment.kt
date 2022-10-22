package com.junsu.movie.presentation.main.fragment.movie.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

class MovieFragment(
    override var parentActivity: AppCompatActivity
) :
    BaseFragment<FragmentMovieBinding>(
        R.layout.fragment_movie
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDailyBoxOffice()
    }

    private fun getDailyBoxOffice() {
        val movieService = MovieService()
        movieService.getDailyBoxOfficeList("20221020")
        println(movieService.toString())
    }

    override fun observeEvent() {}
}