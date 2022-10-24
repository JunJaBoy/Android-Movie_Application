package com.junsu.movie.common

import android.view.View

interface OnMovieItemClickListener {
    fun onMovieItemClick(view: View, movie: ArrayList<Any>)
}