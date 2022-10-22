package com.junsu.movie.data.api

import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getDailyBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String,
    ): Response<DailyBoxOfficeResponse>

    @GET("boxoffice/boxoffice/searchWeeklyBoxOfficeList.json")
    suspend fun getWeeklyBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String,
    ): Response<WeeklyBoxOfficeResponse>
}