package com.example.whatmoviesnow.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    var movie_id: Int = 0

    @SerializedName("title")
    var movie_title: String? = null

    @SerializedName("genre_ids")
    var genreIds: String? = null

    var seeDetais: Boolean = false

//falta a description

    fun getId(): Int { return movie_id }

    fun setId(){ this.movie_id = movie_id }

    fun getTitle(): String? { return movie_title }

    fun setTitle(){ this.movie_title = movie_title }

    fun getGenre(): String? { return genreIds }

    fun setGenre(){ this.genreIds = genreIds }
}