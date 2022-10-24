package com.junsu.movie.presentation.main.fragment.movie.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.common.OnMovieItemClickListener
import com.junsu.movie.data.model.MovieInfo
import com.junsu.movie.data.repository.main.MovieRepository
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.movie.adapter.DailyBoxOfficeAdapter
import com.junsu.movie.presentation.main.fragment.movie.adapter.WeeklyBoxOfficeAdapter
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModel
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModelFactory
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.DialogFragmentMovieMovieInfoBinding
import com.junsu.movieapplication.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MovieViewModelFactory(MovieRepository())
        )[MovieViewModel::class.java]
    }

    private val dailyBoxOfficeAdapter by lazy {
        DailyBoxOfficeAdapter(object : OnMovieItemClickListener {
            override fun onMovieItemClick(view: View, movieCode: String) {
                showMovieInfoDialog(movieCode)
            }
        })
    }

    private val weeklyBoxOfficeAdapter by lazy {
        WeeklyBoxOfficeAdapter(object : OnMovieItemClickListener {
            override fun onMovieItemClick(view: View, movieCode: String) {
                showMovieInfoDialog(movieCode)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViews()

        observeDailyBoxOffice()
        observeWeeklyBoxOffice()
    }

    private fun initRecyclerViews() {
        binding.rvMovieDaily.adapter = dailyBoxOfficeAdapter
        binding.rvMovieWeekly.adapter = weeklyBoxOfficeAdapter
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

    private fun observeWeeklyBoxOffice() {
        viewModel.weeklyBoxOfficeMovies.observe(
            parentActivity
        ) { response ->
            response.body().let {
                if (it != null) {
                    weeklyBoxOfficeAdapter.updateMovies(it.boxOfficeResult.weeklyBoxOfficeList)
                }
            }
        }
    }

    private fun showMovieInfoDialog(movieCode: String) {
        var movieInfo: MovieInfo? = null

        viewModel.getMovieInfo(movieCode)
        viewModel.movieInfo.observe(
            parentActivity
        ) { response ->
            response.body().let {
                movieInfo = it!!.movieInfoResult.movieInfo
            }
        }

        val dialogBinding = DialogFragmentMovieMovieInfoBinding
            .inflate(LayoutInflater.from(parentActivity))

        val dialog = Dialog(parentActivity).apply {
            setContentView(dialogBinding.root)
            setCancelable(false)
            show()
        }

        with(dialogBinding) {
            tvDialogFragmentMovieMovieInfoTitle.text = movieInfo?.title
            tvDialogFragmentMovieMovieInfoAddClose.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    override fun observeEvent() {
    }
}