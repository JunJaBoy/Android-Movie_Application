package com.junsu.movie.presentation.main.fragment.mypage.viewmodel

import com.junsu.movie.data.repository.main.MyPageRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyPageViewModelFactory(private val myPageRepository: MyPageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyPageViewModel(myPageRepository) as T
    }
}