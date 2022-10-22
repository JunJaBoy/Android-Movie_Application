package com.junsu.movie.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest" // + type
    private const val API_KEY = "deca283822d954110693a73fcee8f480"

    private var retrofit: Retrofit? = null

    fun getInstance(type: String): Retrofit? {
        return retrofit ?: let {
            Retrofit.Builder()
                .baseUrl(BASE_URL + type)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

const val BOX_OFFICE = "/boxoffice"
const val MOVIE = "/movie"