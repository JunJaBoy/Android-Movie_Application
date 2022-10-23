package com.junsu.movie.data.repository.main

import com.junsu.movie.data.api.RetrofitClient.API_KEY
import com.junsu.movie.data.api.boxOfficeApiService
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import retrofit2.Response

class MovieRepository {

    suspend fun getDailyBoxOffice(targetDt: String): Response<DailyBoxOfficeResponse> {
        return boxOfficeApiService.getDailyBoxOfficeList(API_KEY, targetDt)
    }

    suspend fun getWeeklyBoxOffice(targetDt: String): Response<WeeklyBoxOfficeResponse> {
        return boxOfficeApiService.getWeeklyBoxOfficeList(API_KEY, targetDt)
    }
}