package com.junsu.movie.presentation.main.fragment.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movie.data.repository.main.MyPageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyPageViewModel(private val myPageRepository: MyPageRepository) : ViewModel() {

    private val _favoriteMovies = MutableLiveData<ArrayList<MovieEntity>>()
    val favoriteMovies: LiveData<ArrayList<MovieEntity>> = _favoriteMovies

    internal fun deleteFavoriteMovie(movieEntity: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                myPageRepository.deleteFavoriteMovie(movieEntity)
            }.onSuccess {
                kotlin.runCatching {
                    myPageRepository.getAllFavoriteMovies()
                }.onSuccess {
                    _favoriteMovies.postValue(it)
                }
            }
        }
    }

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