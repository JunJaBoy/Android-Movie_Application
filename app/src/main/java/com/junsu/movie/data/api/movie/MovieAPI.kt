package com.junsu.movie.data.api.movie

import com.junsu.movie.data.model.MovieInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/searchMovieInfo.json")
    suspend fun getMovieInfo(
        @Query("key") key: String,
        @Query("movieCd") movieCd: String,
    ): Response<MovieInfoResponse>
}