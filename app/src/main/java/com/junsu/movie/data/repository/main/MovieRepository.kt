package com.junsu.movie.data.repository.main

import android.util.Log
import androidx.annotation.WorkerThread
import com.junsu.movie.data.api.RetrofitClient.API_KEY
import com.junsu.movie.data.api.boxOfficeApiService
import com.junsu.movie.data.api.movieApiService
import com.junsu.movie.data.local.favoriteMovieDB
import com.junsu.movie.data.model.DailyBoxOfficeResponse
import com.junsu.movie.data.model.MovieEntity
import com.junsu.movie.data.model.MovieInfoResponse
import com.junsu.movie.data.model.WeeklyBoxOfficeResponse
import org.jsoup.Jsoup
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

    fun getMovieStory(movieTitle: String): String? {
        Jsoup.connect(
            "https://m.search.naver.com/search.naver?sm=mtp_hty.top&where=m&query=영화+${movieTitle}"
        ).get().select(".desc").run {
            return if (this.isEmpty().not()) {
                this.text()
            } else {
                null
            }
        }
    }

    @WorkerThread
    suspend fun insertMovieInfoIntoFavorite(movieEntity: MovieEntity) {
        favoriteMovieDB!!.movieDAO().insert(movieEntity)
    }
}
