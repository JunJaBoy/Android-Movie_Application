package com.junsu.movie

import com.junsu.movie.data.api.MovieService
import com.junsu.movie.data.api.RetrofitClient

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


fun main() {
    getDailyBoxOffice()
}

fun getDailyBoxOffice() {
    val rt = RetrofitClient.getRetrofitClient()
    val movieService = MovieService()
    movieService.getDailyBoxOfficeList("20221020")
    println(movieService.toString())
}