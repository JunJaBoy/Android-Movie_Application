package com.junsu.movie.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieEntity")
data class MovieEntity(
    val title: String,
    val createdAt: String,
) {
    @PrimaryKey(autoGenerate = true)
    val id = 0
}
