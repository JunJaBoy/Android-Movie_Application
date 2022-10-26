package com.junsu.movie.common.util

import android.content.Context
import android.widget.Toast

fun showShortToast(context: Context, text: String) {
    showToast(context, text, Toast.LENGTH_SHORT)
}

fun showLongToast(context: Context, text: String) {
    showToast(context, text, Toast.LENGTH_LONG)
}

fun showToast(context: Context, text: String, length: Int) {
    Toast.makeText(context, text, length).show()
}
