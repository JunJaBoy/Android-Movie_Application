package com.junsu.movie.presentation.main.fragment.movie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.common.util.getDummyDate
import com.junsu.movie.common.util.getToday
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import com.junsu.movie.data.repository.main.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    init {
        /* 주말의 경우 API 제공 안 하는 것으로 추정 */
        getDailyBoxOffice(getToday())
        /* API에서 더이상 지원하지 않는 기능, 이전 날짜로 대체 제공 */
        getWeeklyBoxOffice(getDummyDate())
    }

    private var _dailyBoxOfficeMovies = MutableLiveData<Response<DailyBoxOfficeResponse>>()
    val dailyBoxOfficeMovies: LiveData<Response<DailyBoxOfficeResponse>> = _dailyBoxOfficeMovies

    private var _weeklyBoxOfficeMovies = MutableLiveData<Response<WeeklyBoxOfficeResponse>>()
    val weeklyBoxOfficeMovies: LiveData<Response<WeeklyBoxOfficeResponse>> = _weeklyBoxOfficeMovies

    fun getDailyBoxOffice(targetDate: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getDailyBoxOffice(targetDate) }
                .onSuccess {
                    if (it.isSuccessful) {
                        _dailyBoxOfficeMovies.value = it
                        Log.d(TAG, "getDailyBoxOffice success : ${it.body()}")
                    } else {
                        Log.d(TAG, "getDailyBoxOffice failure : ${it.errorBody()}")
                    }
                }
                .onFailure {
                    Log.e(TAG, "getDailyBoxOffice error", it)
                }
        }
    }

    fun getWeeklyBoxOffice(targetDate: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getWeeklyBoxOffice(targetDate) }
                .onSuccess {
                    if (it.isSuccessful) {
                        _weeklyBoxOfficeMovies.value = it
                        Log.d(TAG, "getWeeklyBoxOffice success : ${it.body()}")
                    } else {
                        Log.d(TAG, "getWeeklyBoxOffice failure : ${it.errorBody()}")
                    }
                }
                .onFailure {
                    Log.e(TAG, "getWeeklyBoxOffice error", it)
                }
        }
    }
}