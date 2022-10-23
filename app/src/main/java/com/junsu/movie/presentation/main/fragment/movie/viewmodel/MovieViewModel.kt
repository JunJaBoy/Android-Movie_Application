package com.junsu.movie.presentation.main.fragment.movie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.common.util.getDummyDate
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import com.junsu.movie.data.repository.main.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    init {
        getDailyBoxOffice(getDummyDate())
        getWeeklyBoxOffice(getDummyDate())
    }

    private var _dailyBoxOfficeMovies = MutableLiveData<Response<DailyBoxOfficeResponse>>()
    val dailyBoxOfficeMovies: LiveData<Response<DailyBoxOfficeResponse>> = _dailyBoxOfficeMovies

    private var _weeklyBoxOfficeMovies = MutableLiveData<Response<WeeklyBoxOfficeResponse>>()
    val weeklyBoxOfficeMovies: LiveData<Response<WeeklyBoxOfficeResponse>> = _weeklyBoxOfficeMovies

    fun getDailyBoxOffice(targetDt: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getDailyBoxOffice(targetDt) }
                .onSuccess {
                    _dailyBoxOfficeMovies.value = it
                }
                .onFailure {
                    Log.e("MovieViewModel", "getDailyBoxOffice error", it)
                }
        }
    }

    fun getWeeklyBoxOffice(targetDt: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getWeeklyBoxOffice(targetDt) }
                .onSuccess {
                    _weeklyBoxOfficeMovies.value = it
                }
                .onFailure {
                    Log.e("MovieViewModel", "getDailyBoxOffice error", it)
                }
        }
    }
}