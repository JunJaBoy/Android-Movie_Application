package com.junsu.movie.common

import com.junsu.movie.data.model.MovieEntity

interface OnMovieItemClickListener {
    fun onMovieItemClick(movieCode: String)
}

interface OnFavoriteItemClickListener {
    fun onDeleteFavoriteItemClick(movieEntity: MovieEntity)
}