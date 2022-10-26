package com.junsu.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.junsu.movie.data.model.MovieEntity

@Dao
interface MovieEntityDAO {
    @Insert
    fun insert(movieEntity: MovieEntity)

    @Delete
    fun delete(movieEntity: MovieEntity)

    @Query("SELECT * FROM MovieEntity")
    fun getAll(): List<MovieEntity>
}