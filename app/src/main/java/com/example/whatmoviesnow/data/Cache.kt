package com.example.whatmoviesnow.data

import com.example.whatmoviesnow.model.Genre
import com.example.whatmoviesnow.model.Movie

object Cache{
    val genreList: MutableList<Genre> by lazy { mutableListOf<Genre>() }
    val movieList: MutableList<Movie> by lazy { mutableListOf<Movie>() }
    val page: Int = 1
    var totalPages: Int? = 0

    var actionId = 0
    var dramaId = 0
    var fantasyId = 0
    var fictionId = 0
}
