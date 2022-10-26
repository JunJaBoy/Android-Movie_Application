package com.junsu.movie.presentation.main.fragment.mypage.view

import MyPageRepository
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movie.presentation.main.fragment.mypage.viewmodel.MyPageViewModel
import com.junsu.movie.presentation.main.fragment.mypage.viewmodel.MyPageViewModelFactory
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMypageBinding

class MyPageFragment :
    BaseFragment<FragmentMypageBinding>(
        R.layout.fragment_mypage
    ) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            MyPageViewModelFactory(MyPageRepository())
        )[MyPageViewModel::class.java]
    }

    override fun observeEvent() {}
}