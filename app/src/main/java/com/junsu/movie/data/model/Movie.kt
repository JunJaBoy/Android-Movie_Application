package com.junsu.movie.data.model

import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: DailyBoxOfficeResult,
    @SerializedName("targetDt") val targetDt: String,
)

data class DailyBoxOfficeResult(
    @SerializedName("showRange") val showRange: String,
    @SerializedName("dailyBoxOfficeList") val dailyBoxOfficeList: List<DailyBoxOfficeList>,
)

data class DailyBoxOfficeList(
    @SerializedName("rank") val rank: String,
    @SerializedName("movieNm") val movieNm: String,
    @SerializedName("audiCnt") val audiCnt: String,
    @SerializedName("audiAcc") val audiAcc: String,
)
