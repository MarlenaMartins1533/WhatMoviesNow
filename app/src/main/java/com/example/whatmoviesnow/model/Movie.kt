package com.example.whatmoviesnow.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    var seeDetails: Boolean = false

    constructor()
    constructor(movie_id: Int, movie_title: String, genre_id: List<Int>, poster_path: String) {

        this.id = movie_id
        this.title = movie_title
        this.genreIds = genre_id
        this.posterPath = poster_path
    }
}