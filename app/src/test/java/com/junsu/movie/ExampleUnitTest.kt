package com.junsu.movie

import android.util.Log
import org.jsoup.Jsoup

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
fun main() {
    val movieTitle = "소울"
    val document = Jsoup.connect(
        "https://m.search.naver.com/search.naver?sm=mtp_hty.top&where=m&query=영화+${movieTitle}"
    ).get()
    document.select(".desc").run {
        if (this.isEmpty().not()) {
            // TODO remove
            Log.d("MovieRepository", "Success")
            this.text()
        } else {
            // TODO remove
            Log.d("MovieRepository", "Failure")
        }
    }
}