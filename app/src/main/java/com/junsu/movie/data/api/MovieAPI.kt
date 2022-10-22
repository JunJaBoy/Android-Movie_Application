package com.junsu.movie.data.api

import com.junsu.movie.data.model.DailyBoxOfficeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    fun getDailyBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String,
    ): Call<DailyBoxOfficeResponse>
}