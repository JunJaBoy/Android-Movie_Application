package com.junsu.movie.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieEntity")
data class MovieEntity(
    var title: String,
    var createdAt: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
