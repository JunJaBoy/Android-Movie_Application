package com.junsu.movie.presentation.main.fragment.movie.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.common.OnMovieItemClickListener
import com.junsu.movie.data.model.MovieInfo
import com.junsu.movie.data.repository.main.MovieRepository
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.movie.adapter.*
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModel
import com.junsu.movie.presentation.main.fragment.movie.viewmodel.MovieViewModelFactory
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.DialogFragmentMovieMovieInfoBinding
import com.junsu.movieapplication.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<FragmentMovieBinding>(
    R.layout.fragment_movie
) {

    var movieInfo: MovieInfo? = null

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

    private val movieInfoDialogActorsAdapter by lazy {
        MovieInfoDialogActorsAdapter(movieInfo?.actors)
    }

    private val movieInfoDialogDirectorsAdapter by lazy {
        MovieInfoDialogDirectorsAdapter(movieInfo?.directors)
    }

    private val movieInfoDialogGenresAdapter by lazy {
        MovieInfoDialogGenresAdapter(movieInfo?.genres)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViews()
    }

    private fun initRecyclerViews() {
        binding.rvMovieDaily.adapter = dailyBoxOfficeAdapter
        binding.rvMovieWeekly.adapter = weeklyBoxOfficeAdapter
    }

    private fun showMovieInfoDialog(movieCode: String) {
        val dialogBinding = DialogFragmentMovieMovieInfoBinding
            .inflate(LayoutInflater.from(parentActivity))

        val dialog = Dialog(parentActivity).apply {
            setContentView(dialogBinding.root)
            setCancelable(false)
            window!!.attributes.apply {
                width = WindowManager.LayoutParams.MATCH_PARENT
                height = WindowManager.LayoutParams.WRAP_CONTENT
            }
            show()
        }

        viewModel.getMovieInfo(movieCode)
        viewModel.movieInfo.observe(
            parentActivity
        ) { response ->
            response.body().let {
                movieInfo = it!!.movieInfoResult.movieInfo

                movieInfoDialogActorsAdapter.updateActors(movieInfo!!.actors)
                movieInfoDialogDirectorsAdapter.updateActors(movieInfo!!.directors)
                movieInfoDialogGenresAdapter.updateActors(movieInfo!!.genres)

                initDialogBinding(dialogBinding, dialog)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initDialogBinding(
        dialogBinding: DialogFragmentMovieMovieInfoBinding,
        dialog: Dialog
    ) {
        with(dialogBinding) {


            rvDialogFragmentMovieMovieInfoTitleActors.adapter =
                movieInfoDialogActorsAdapter

            rvDialogFragmentMovieMovieInfoTitleDirectors.adapter =
                movieInfoDialogDirectorsAdapter

            rvDialogFragmentMovieMovieInfoTitleGenres.adapter =
                movieInfoDialogGenresAdapter

            tvDialogFragmentMovieMovieInfoTitle.text = movieInfo?.title
            tvDialogFragmentMovieMovieInfoAudit.text = movieInfo?.audits?.get(0)?.audit
            tvDialogFragmentMovieMovieInfoRunningTime.text = "${movieInfo?.runningTime}분"
            tvDialogFragmentMovieMovieInfoReleaseDate.text = movieInfo?.releaseDate
            tvDialogFragmentMovieMovieInfoAddClose.setOnClickListener {
                dialog.dismiss()
            }
            tvDialogFragmentMovieMovieInfoAddFavorite.setOnClickListener {
                
            }
        }
    }

    override fun observeEvent() {
        viewModel.dailyBoxOfficeMovies.observe(
            parentActivity
        ) { response ->
            response.body().let {
                if (it != null) {
                    dailyBoxOfficeAdapter.updateMovies(it.boxOfficeResult.dailyBoxOfficeList)
                }
            }
        }

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
}