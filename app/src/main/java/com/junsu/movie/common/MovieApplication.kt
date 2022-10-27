package com.junsu.movie.common

import android.app.Application
import com.junsu.movie.data.local.FavoriteMovieDB
import com.junsu.movie.data.local.favoriteMovieDB

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        favoriteMovieDB = FavoriteMovieDB.getInstance(this)
    }
}
