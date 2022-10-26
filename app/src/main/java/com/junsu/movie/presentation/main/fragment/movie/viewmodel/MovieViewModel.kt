package com.junsu.movie.presentation.main.fragment.movie.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junsu.movie.common.util.getDummyDate
import com.junsu.movie.data.local.FavoriteMovieDB
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movie.data.model.MovieInfoResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import com.junsu.movie.data.repository.main.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val tag: String = this.javaClass.simpleName

    init {
        /* 주말의 경우 API 제공 안 하는 것으로 추정, 더미 날짜를 사용하여 제공 */
        getDailyBoxOffice(/*getToday()*/getDummyDate())
        /* API에서 더이상 지원하지 않는 기능, 이전 날짜로 대체 제공 */
        getWeeklyBoxOffice(getDummyDate())
    }

    private var _dailyBoxOfficeMovies = MutableLiveData<Response<DailyBoxOfficeResponse>>()
    val dailyBoxOfficeMovies: LiveData<Response<DailyBoxOfficeResponse>> = _dailyBoxOfficeMovies

    private var _weeklyBoxOfficeMovies = MutableLiveData<Response<WeeklyBoxOfficeResponse>>()
    val weeklyBoxOfficeMovies: LiveData<Response<WeeklyBoxOfficeResponse>> = _weeklyBoxOfficeMovies

    private var _movieInfo = MutableLiveData<Response<MovieInfoResponse>>()
    val movieInfo: LiveData<Response<MovieInfoResponse>> = _movieInfo

    private var _insertMovieInfoIntoFavoriteFlag = MutableLiveData<Boolean>().also {
        it.value = false
    }
    val insertMovieInfoIntoFavoriteFlag: LiveData<Boolean> = _insertMovieInfoIntoFavoriteFlag

    private fun getDailyBoxOffice(targetDate: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getDailyBoxOffice(targetDate) }
                .onSuccess {
                    if (it.isSuccessful) {
                        _dailyBoxOfficeMovies.value = it
                        Log.d(tag, "getDailyBoxOffice success : ${it.body()}")
                    } else {
                        Log.d(tag, "getDailyBoxOffice failure : ${it.errorBody()}")
                    }
                }
                .onFailure {
                    Log.e(tag, "getDailyBoxOffice error", it)
                }
        }
    }

    private fun getWeeklyBoxOffice(targetDate: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getWeeklyBoxOffice(targetDate) }
                .onSuccess {
                    if (it.isSuccessful) {
                        _weeklyBoxOfficeMovies.value = it
                        Log.d(tag, "getWeeklyBoxOffice success : ${it.body()}")
                    } else {
                        Log.d(tag, "getWeeklyBoxOffice failure : ${it.errorBody()}")
                    }
                }
                .onFailure {
                    Log.e(tag, "getWeeklyBoxOffice error", it)
                }
        }
    }

    internal fun getMovieInfo(movieCode: String) {
        viewModelScope.launch {
            kotlin.runCatching { repository.getMovieInfo(movieCode) }
                .onSuccess {
                    if (it.isSuccessful) {
                        _movieInfo.value = it
                        Log.d(tag, "getMovieInfo success : ${it.body()}")
                    } else {
                        Log.d(tag, "getMovieInfo failure : ${it.errorBody()}")
                    }
                }
                .onFailure {
                    Log.e(tag, "getMovieInfo error", it)
                }
        }
    }

    private fun insertMovieInfoIntoFavorite(context: Context, movieEntity: MovieEntity) {
        viewModelScope.launch {
            kotlin.runCatching {
                val database = FavoriteMovieDB.getInstance(context)
                database!!.movieDAO().insert(movieEntity)
            }.onSuccess {
                _insertMovieInfoIntoFavoriteFlag.value = true
            }.onFailure {
                _insertMovieInfoIntoFavoriteFlag.value = false
            }
        }
    }
}