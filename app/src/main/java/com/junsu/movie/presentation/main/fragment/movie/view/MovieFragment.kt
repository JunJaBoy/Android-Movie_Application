package com.junsu.movie.presentation.main.fragment.movie.view

import android.content.Context
import com.junsu.movie.data.api.MovieService
import com.junsu.movie.data.api.RetrofitClient
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {
    //        getDailyBoxOffice()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    fun getDailyBoxOffice() {
        val rt = RetrofitClient.getRetrofitClient()
        val movieService = MovieService()
        movieService.getDailyBoxOfficeList("20221020")
        println(movieService.toString())
    }

    override fun observeEvent() {}
}