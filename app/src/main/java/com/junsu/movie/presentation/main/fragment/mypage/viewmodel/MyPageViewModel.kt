package com.junsu.movie.presentation.main.fragment.mypage.viewmodel

import MyPageRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.data.model.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyPageViewModel(private val myPageRepository: MyPageRepository) : ViewModel() {

    private val tag: String = this.javaClass.simpleName

    init {
        getAllFavoriteMovies()
    }

    private var _favoriteMovies = MutableLiveData<ArrayList<MovieEntity>>()
    val favoriteMovies: LiveData<ArrayList<MovieEntity>> = _favoriteMovies

    internal fun getAllFavoriteMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                myPageRepository.getAllFavoriteMovies()
            }.onSuccess {
                _favoriteMovies.postValue(it)
            }
        }
    }
}