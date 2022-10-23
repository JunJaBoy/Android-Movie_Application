package com.junsu.movie.common.util

import java.text.SimpleDateFormat
import java.util.*

fun getDummyDate(): String {
    return "20120210"
}

fun getToday(): String {
    return getDateFormatter().format(Calendar.getInstance().time)
}

fun getDateFormatter(): SimpleDateFormat {
    return SimpleDateFormat("yyyyMMdd", Locale.getDefault())
}
