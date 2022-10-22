package com.junsu.movie.presentation.main.fragment.mypage.view

import androidx.appcompat.app.AppCompatActivity
import com.junsu.movie.presentation.base.BaseFragment
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.FragmentMypageBinding

class MyPageFragment(
    override var parentActivity: AppCompatActivity
) :
    BaseFragment<FragmentMypageBinding>(
        R.layout.fragment_mypage
    ) {


    override fun observeEvent() {}
}