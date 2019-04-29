package com.example.whatmoviesnow.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    var movie_id: Int = 0

    @SerializedName("title")
    var movie_title: String? = null

    @SerializedName("genre_ids")
    var genreIds: Int? = null

    var seeDetais: Boolean = false

    constructor()
    constructor(movie_id: Int, movie_title: String) {

        this.movie_id = movie_id
        this.movie_title = movie_title
    }

}