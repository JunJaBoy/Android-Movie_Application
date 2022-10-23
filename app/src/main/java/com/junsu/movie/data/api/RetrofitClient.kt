package com.junsu.movie.data.api

import com.junsu.movie.data.api.movie.BoxOfficeAPI
import com.junsu.movie.data.api.movie.MovieAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/" // + type
    const val API_KEY = "deca283822d954110693a73fcee8f480"

    private var retrofit: Retrofit? = null

    fun getRetrofitClient(): Retrofit? {
        return retrofit ?: let {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

val boxOfficeApiService: BoxOfficeAPI by lazy {
    RetrofitClient.getRetrofitClient()!!.create(BoxOfficeAPI::class.java)
}

val movieApiService: MovieAPI by lazy {
    RetrofitClient.getRetrofitClient()!!.create(MovieAPI::class.java)
}