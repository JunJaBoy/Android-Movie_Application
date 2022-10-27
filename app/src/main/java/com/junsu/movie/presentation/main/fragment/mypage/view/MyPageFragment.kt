package com.junsu.movie.presentation.main.fragment.mypage.view

import MyPageRepository
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.common.OnFavoriteItemClickListener
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.mypage.adapter.MyPageFavoritesAdapter
import com.junsu.movie.presentation.main.fragment.mypage.viewmodel.MyPageViewModel
import com.junsu.movie.presentation.main.fragment.mypage.viewmodel.MyPageViewModelFactory
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMypageBinding

class MyPageFragment : BaseFragment<FragmentMypageBinding>(
    R.layout.fragment_mypage
) {

    private var favoriteMovies: ArrayList<MovieEntity>? = null

    private val viewModel by lazy {
        ViewModelProvider(
            this, MyPageViewModelFactory(MyPageRepository())
        )[MyPageViewModel::class.java]
    }

    private val myPageFavoritesAdapter by lazy {
        MyPageFavoritesAdapter(object : OnFavoriteItemClickListener {
            override fun onDeleteFavoriteItemClick(view: View) {
                showDeleteFavoriteDialog()
            }
        })
    }

    private fun showDeleteFavoriteDialog() {
        val dialog = AlertDialog.Builder(parentActivity).apply {
            setTitle(getString(R.string.my_page_fragment_sure_you_delete))
            setCancelable(false)
        }
        with(dialog) {
            create().apply {
                setPositiveButton(
                    getString(R.string.accept)
                ) { _, _ ->
                    deleteFavoriteMovie()
                }
                setNeutralButton(
                    getString(R.string.cancel)
                ) { _, _ ->
                    dismiss()
                }
            }
            show()
        }
    }

    // TODO 잘 옮기기
    private fun deleteFavoriteMovie() {
    }

    private fun initRecyclerView() {
        binding.rvMypageDaily.adapter = myPageFavoritesAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

    }

    override fun observeEvent() {
        viewModel.favoriteMovies.observe(
            parentActivity
        ) {
            favoriteMovies = it
            println(it)
            myPageFavoritesAdapter.updateFavoriteMovies(it)
        }
    }
}