package com.junsu.movie.presentation.main.fragment.mypage.viewmodel

import MyPageRepository
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.data.local.getFavoriteMovieDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyPageViewModel(private val myPageRepository: MyPageRepository) : ViewModel() {

    suspend fun getAllFavoriteMovies(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                myPageRepository.getAllFavoriteMovies(getFavoriteMovieDB(context))
            }.onSuccess {
                
            }
        }
    }
}