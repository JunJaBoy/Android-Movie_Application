package com.junsu.movie.data.model

import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: BoxOfficeResult,
    @SerializedName("targetDt") val targetDt: String,
)

data class BoxOfficeResult(
    @SerializedName("boxofficeType") val boxofficeType: String,
    @SerializedName("showRange") val showRange: String,
    @SerializedName("dailyBoxOfficeList") val dailyBoxOfficeList: List<DailyBoxOfficeList>,
)

data class DailyBoxOfficeList(
    @SerializedName("rank") val rank: String,
    @SerializedName("movieNm") val movieNm: String,
    @SerializedName("audiCnt") val audiCnt: String,
    @SerializedName("audiAcc") val audiAcc: String,
)