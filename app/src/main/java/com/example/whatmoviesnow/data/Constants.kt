package com.example.whatmoviesnow.data

import com.example.whatmoviesnow.model.Genre
import com.example.whatmoviesnow.model.Movie

object Constants {

    const val BaseUrl = "https://api.themoviedb.org/3/"
    const val AppId: String = "b7998e0023a9f2977d5569934f9d82f1"

    val genreList: MutableList<Genre> by lazy { mutableListOf<Genre>() }
    val movieList: MutableList<Movie> by lazy { mutableListOf<Movie>() }
    val page: Int = 1
    val totalPages: Int = 0

    var actionId = 0
    var dramaId = 0
    var fantasyId = 0
    var fictionId = 0
}
