package com.junsu.movie.data.model

import androidx.room.Entity

@Entity(tableName = "MovieEntity")
data class MovieEntity(
    var title: String,
    var createdAt: String,
    var movieInfo: MovieInfo,
) {
    var id = 0
}