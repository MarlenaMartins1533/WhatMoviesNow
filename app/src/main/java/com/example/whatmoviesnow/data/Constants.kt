package com.example.whatmoviesnow.data

import com.example.whatmoviesnow.model.Genre
import com.example.whatmoviesnow.model.Movie

object Constants {

    const val baseUrl = "https://api.themoviedb.org/3/"
    const val imageUrl = "https://image.tmdb.org/t/p/w500/"
    const val appId: String = "b7998e0023a9f2977d5569934f9d82f1"
    const val language: String = "pt-BR"

    val genreList: MutableList<Genre> by lazy { mutableListOf<Genre>() }
    val movieList: MutableList<Movie> by lazy { mutableListOf<Movie>() }
    val page: Int = 1
    var totalPages: Int? = 0

    var actionId = 0
    var dramaId = 0
    var fantasyId = 0
    var fictionId = 0
}
