package com.junsu.movie.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.junsu.movie.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class FavoriteMovieDB : RoomDatabase() {

    abstract fun movieDAO(): MovieEntityDAO

    companion object {
        private var instance: FavoriteMovieDB? = null

        @Synchronized
        fun getInstance(context: Context): FavoriteMovieDB? {
            if (instance == null) {
                synchronized(FavoriteMovieDB::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteMovieDB::class.java,
                        "database"
                    ).build()
                }
            }
            return instance
        }
    }
}

var favoriteMovieDB: FavoriteMovieDB? = null
fun getFavoriteMovieDB(context: Context): FavoriteMovieDB = FavoriteMovieDB.getInstance(context)!!
