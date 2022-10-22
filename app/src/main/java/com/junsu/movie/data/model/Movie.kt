package com.junsu.movie.data.model

import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: DailyBoxOfficeResult,
)

data class DailyBoxOfficeResult(
    @SerializedName("dailyBoxOfficeList") val dailyBoxOfficeList: List<DailyBoxOfficeList>,
)

data class DailyBoxOfficeList(
    @SerializedName("rank") val rank: String,
    @SerializedName("movieNm") val title: String,
    @SerializedName("audiCnt") val dailyAudienceCount: String,
    @SerializedName("audiAcc") val totalAudienceCount: String,
)
