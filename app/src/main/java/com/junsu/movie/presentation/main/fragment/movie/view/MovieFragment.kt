package com.junsu.movie.presentation.main.fragment.movie.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.common.util.getDummyDate
import com.junsu.movie.data.repository.main.MovieRepository
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.movie.adapter.DailyBoxOfficeAdapter
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModel
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModelFactory
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

// 순위에 따라 금, 은, 동색 순위
class MovieFragment: BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MovieViewModelFactory(MovieRepository())
        )[MovieViewModel::class.java]
    }

    private val dailyBoxOfficeAdapter by lazy {
        DailyBoxOfficeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBoxOffice()

        binding.rvMovieDaily.adapter = dailyBoxOfficeAdapter
        observeDailyBoxOffice()
    }

    private fun initBoxOffice() {
        viewModel.getDailyBoxOffice(getDummyDate())
    }

    private fun observeDailyBoxOffice() {
        viewModel.dailyBoxOfficeMovies.observe(
            parentActivity
        ) { response ->
            response.body().let {
                if (it != null) {
                    dailyBoxOfficeAdapter.updateMovies(it.boxOfficeResult.dailyBoxOfficeList)
                }
            }
        }
    }

    override fun observeEvent() {
    }
}