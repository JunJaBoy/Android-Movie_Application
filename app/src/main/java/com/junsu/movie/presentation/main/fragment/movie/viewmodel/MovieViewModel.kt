package com.junsu.movie.presentation.main.fragment.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.repository.main.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(private val mainRepository: MovieRepository) : ViewModel() {

    private var _dailyBoxOfficeMovies = MutableLiveData<Response<DailyBoxOfficeResponse>>()
    val dailyBoxOfficeMovies: LiveData<Response<DailyBoxOfficeResponse>> = _dailyBoxOfficeMovies

    fun getDailyBoxOffice(targetDt: String) {
        viewModelScope.launch {
            _dailyBoxOfficeMovies.postValue(mainRepository.getDailyBoxOffice(targetDt))
        }
    }
}