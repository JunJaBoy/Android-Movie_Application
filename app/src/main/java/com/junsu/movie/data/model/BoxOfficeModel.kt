package com.junsu.movie.data.model

import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: DailyBoxOfficeResult,
)

data class DailyBoxOfficeResult(
    @SerializedName("dailyBoxOfficeList") val dailyBoxOfficeList: ArrayList<DailyBoxOfficeList>,
)

data class DailyBoxOfficeList(
    @SerializedName("rank") val rank: String,
    @SerializedName("movieNm") val title: String,
    @SerializedName("audiCnt") val dailyAudienceCount: String,
    @SerializedName("audiAcc") val totalAudienceCount: String,
    @SerializedName("movieCd") val movieCode: String,
)

data class WeeklyBoxOfficeResponse(
    @SerializedName("boxOfficeResult") val boxOfficeResult: WeeklyBoxOfficeResult,
)

data class WeeklyBoxOfficeResult(
    @SerializedName("weeklyBoxOfficeList") val weeklyBoxOfficeList: ArrayList<WeeklyBoxOfficeList>,
)

data class WeeklyBoxOfficeList(
    @SerializedName("rank") val rank: String,
    @SerializedName("movieNm") val title: String,
    @SerializedName("audiCnt") val weeklyAudienceCount: String,
    @SerializedName("audiAcc") val totalAudienceCount: String,
    @SerializedName("movieCd") val movieCode: String,
)