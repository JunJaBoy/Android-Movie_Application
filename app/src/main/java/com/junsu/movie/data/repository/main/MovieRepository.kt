package com.junsu.movie.data.repository.main

import com.junsu.movie.data.api.RetrofitClient
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import retrofit2.Response
import retrofit2.create

class MovieRepository {
    suspend fun getDailyBoxOffice(targetDt: String): Response<DailyBoxOfficeResponse> {
        return RetrofitClient.getRetrofitClient()!!.create()
    }
}