package com.junsu.movie.presentation.main.fragment.movie.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.movie.adapter.DailyBoxOfficeAdapter
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

// 순위에 따라 금, 은, 동색 순위
class MovieFragment(
    override var parentActivity: AppCompatActivity
) : BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {


    private lateinit var dailyBoxOfficeAdapter: DailyBoxOfficeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dailyBoxOfficeAdapter = DailyBoxOfficeAdapter()
        binding.rvMovieDaily.adapter = dailyBoxOfficeAdapter




        getDailyBoxOffice()
    }

    // TODO make it returns value
    private fun getDailyBoxOffice() {
        val movieService = MovieService()
        movieService.getDailyBoxOfficeList("20221020")
        println(movieService.toString())
    }

    override fun observeEvent() {}
}