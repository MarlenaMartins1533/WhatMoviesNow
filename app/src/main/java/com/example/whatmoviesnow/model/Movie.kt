package com.example.whatmoviesnow.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    var movie_id: Int = 0

    @SerializedName("title")
    var movie_title: String? = null

    @SerializedName("genre_id")
    var genre_id: Int? = null

    var seeDetails: Boolean = false

    constructor()
    constructor(movie_id: Int, movie_title: String, genre_id: Int) {

        this.movie_id = movie_id
        this.movie_title = movie_title
        this.genre_id = genre_id
    }
}