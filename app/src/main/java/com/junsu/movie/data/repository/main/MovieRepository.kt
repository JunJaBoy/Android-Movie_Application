package com.junsu.movie.data.repository.main

import com.junsu.movie.data.api.RetrofitClient.API_KEY
import com.junsu.movie.data.api.boxOfficeApiService
import com.junsu.movie.data.api.movieApiService
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.MovieInfoResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import retrofit2.Response

class MovieRepository {

    suspend fun getDailyBoxOffice(targetDate: String): Response<DailyBoxOfficeResponse> {
        return boxOfficeApiService.getDailyBoxOfficeList(API_KEY, targetDate)
    }

    suspend fun getWeeklyBoxOffice(targetDate: String): Response<WeeklyBoxOfficeResponse> {
        return boxOfficeApiService.getWeeklyBoxOfficeList(API_KEY, targetDate)
    }

    suspend fun getMovieInfo(movieCode: String): Response<MovieInfoResponse> {
        return movieApiService.getMovieInfo(API_KEY, movieCode)
    }
}