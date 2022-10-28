package com.junsu.movie.common.util

import java.text.SimpleDateFormat
import java.util.*

fun getDummyDate() = "20120210"

fun getToday(): String = getDateFormatter().format(Calendar.getInstance().time)


fun getDateFormatter() = SimpleDateFormat("yyyyMMdd", Locale.getDefault())

