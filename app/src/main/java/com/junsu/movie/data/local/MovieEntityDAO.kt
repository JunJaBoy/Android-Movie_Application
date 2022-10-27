package com.junsu.movie.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.junsu.movie.data.model.MovieEntity

@Dao
interface MovieEntityDAO {

    @Insert
    suspend fun insert(movieEntity: MovieEntity)

    @Delete
    suspend fun delete(movieEntity: MovieEntity)

    @Query("SELECT * FROM MovieEntity")
    suspend fun getAll(): List<MovieEntity>
}