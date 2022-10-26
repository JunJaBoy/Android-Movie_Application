package com.junsu.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.junsu.movie.data.model.MovieInfo

@Dao
interface MovieEntityDAO {
    @Insert
    fun insert(movieInfo: MovieInfo, createdAt: String)

    @Delete
    fun delete(movieInfo: MovieInfo)

    @Query("SELECT * FROM MovieEntity")
    fun getAll(): ArrayList<MovieInfo>
}