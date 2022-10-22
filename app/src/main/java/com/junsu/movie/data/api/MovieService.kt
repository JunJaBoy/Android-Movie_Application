package com.junsu.movie.data.api

import android.util.Log
import com.junsu.movie.data.api.RetrofitClient.API_KEY
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
fun login(loginRequest: LoginRequest) {
    val authService = retrofit?.create(AuthRetrofitInterface::class.java)
    authService!!.login(loginRequest).enqueue(object : Callback<AuthResponse> {
        override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
            Log.d("API/LOGIN/SUCCESS", response.body().toString())
            if (response.isSuccessful) {
                loginView.onLoginSuccess(response.body()!!.result)
            } else {
                loginView.onLoginFailure()
            }
        }

        override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
            Log.d("API/LOGIN/FAILURE", t.message.toString())
        }
    })
}*/

class MovieService {
    private var retrofit = RetrofitClient.getRetrofitClient()

    fun getDailyBoxOfficeList(targetDt: String) {
        val movieAPI = retrofit?.create(MovieAPI::class.java)
        movieAPI!!.getDailyBoxOfficeList(API_KEY, targetDt)
            .enqueue(object : Callback<DailyBoxOfficeResponse> {

                override fun onResponse(
                    call: Call<DailyBoxOfficeResponse>, response: Response<DailyBoxOfficeResponse>
                ) {
                    Log.d("API/DAILYBOXOFFICE/S", response.body().toString())

                    if (response.isSuccessful) {
                        // todo success

                    } else {
                        // todo failure
                    }
                }

                override fun onFailure(
                    call: Call<DailyBoxOfficeResponse>,
                    t: Throwable
                ) {
                    Log.d("API/DAILYBOXOFFICE/F", t.message.toString())
                }
            })
    }
}