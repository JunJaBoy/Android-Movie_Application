package com.junsu.movie.data.model

import com.google.gson.annotations.SerializedName

data class MovieInfoResponse(
    @SerializedName("movieInfoResult") val movieInfoResult: MovieInfoResult,
)

data class MovieInfoResult(
    @SerializedName("movieInfo") val movieInfo: ArrayList<MovieInfo>,
)

data class MovieInfo(
    @SerializedName("movieNm") val title: String,
    @SerializedName("showTm") val runningTime: String,
    @SerializedName("openDt") val releaseDate: String,
    @SerializedName("genres") val genres: ArrayList<MovieGenre>,
    @SerializedName("directors") val directors: ArrayList<MovieDirector>,
    @SerializedName("actors") val actors: ArrayList<MovieActor>,
    @SerializedName("audits") val audits: ArrayList<Audit>,
)

data class MovieGenre(
    @SerializedName("genreNm") val genre: String,
)

data class MovieDirector(
    @SerializedName("peopleNm") val director: String,
)

data class MovieActor(
    @SerializedName("peopleNm") val actor: String,
)

data class Audit(
    @SerializedName("watchGradeNm") val audit: String,
)
