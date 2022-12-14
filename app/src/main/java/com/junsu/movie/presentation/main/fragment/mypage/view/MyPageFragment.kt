package com.junsu.movie.presentation.main.fragment.mypage.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.common.OnFavoriteItemClickListener
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movie.data.repository.main.MyPageRepository
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
            requireActivity(), MyPageViewModelFactory(MyPageRepository())
        )[MyPageViewModel::class.java]
    }

    private val myPageFavoritesAdapter by lazy {
        MyPageFavoritesAdapter(object : OnFavoriteItemClickListener {
            override fun onDeleteFavoriteItemClick(movieEntity: MovieEntity) {
                showDeleteFavoriteDialog(movieEntity)
            }
        })
    }

    private fun showDeleteFavoriteDialog(movieEntity: MovieEntity) {
        AlertDialog.Builder(requireActivity()).apply {
            setTitle(getString(R.string.my_page_fragment_sure_you_delete))
            setCancelable(false)
            create().apply {
                setPositiveButton(
                    getString(R.string.accept)
                ) { _, _ ->
                    deleteFavoriteMovie(movieEntity)
                }
                setNeutralButton(
                    getString(R.string.cancel)
                ) { _, _ ->
                    dismiss()
                }
            }
        }.show()
    }

    // TODO ??? ?????????
    private fun deleteFavoriteMovie(movieEntity: MovieEntity) {
        viewModel.deleteFavoriteMovie(movieEntity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        viewModel.getAllFavoriteMovies()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMypageDaily.adapter = myPageFavoritesAdapter
    }

    override fun observeEvent() {
        viewModel.favoriteMovies.observe(
            requireActivity()
        ) {
            favoriteMovies = it
            println("Favorite movies : $it")
            myPageFavoritesAdapter.updateFavoriteMovies(it)
        }
    }
}
