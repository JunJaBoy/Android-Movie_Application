package com.junsu.movie.presentation.main.fragment.movie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.junsu.movie.data.repository.main.MovieRepository

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(movieRepository) as T
    }
}