package com.junsu.movie.data.model

import androidx.room.Entity

@Entity(tableName = "MovieEntity")
data class MovieEntity(
    var movieInfo: MovieInfo,
    var createdAt: String,
) {
    var id = 0
}