package com.junsu.movie.presentation.main.fragment.movie.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.data.model.DailyBoxOfficeList
import com.junsu.movie.data.repository.main.MovieRepository
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.movie.adapter.DailyBoxOfficeAdapter
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModel
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMovieBinding

// 순위에 따라 금, 은, 동색 순위
class MovieFragment(
    override var parentActivity: AppCompatActivity
) : BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {

    

    private var movies = ArrayList<DailyBoxOfficeList>()

    private val dailyBoxOfficeAdapter by lazy {
        DailyBoxOfficeAdapter(movies)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("hihi" , "${movies.toArray()}")

        Log.d("HOIHOI", "${viewModel.getDailyBoxOffice("20221020")}")

        binding.rvMovieDaily.adapter = dailyBoxOfficeAdapter



    }

    override fun observeEvent() {
        viewModel.dailyBoxOfficeMovies.observe(
            this
        ) {
            dailyBoxOfficeAdapter.updateMovies(movies)
        }
    }
}