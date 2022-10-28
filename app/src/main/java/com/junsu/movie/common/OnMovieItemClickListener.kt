package com.junsu.movie.common

import android.view.View
import com.junsu.movie.data.model.MovieEntity

interface OnMovieItemClickListener {
    fun onMovieItemClick(movieCode: String)
}

interface OnFavoriteItemClickListener {
    fun onDeleteFavoriteItemClick(movieEntity: MovieEntity)
}