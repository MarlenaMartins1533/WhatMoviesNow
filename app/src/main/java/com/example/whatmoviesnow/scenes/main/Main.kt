package com.example.whatmoviesnow.scenes.main

import com.example.whatmoviesnow.model.Genre
import com.example.whatmoviesnow.model.GenreResponse
import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.scenes.Scenes


interface Main {

    interface View: Scenes.View {
        fun setGenreList (genreList: GenreResponse?)
        fun setMoviesList (MoviesList: MutableList<Movie>?)
    }

    interface Presenter: Scenes.Presenter {
        fun getGenres()
        fun getMoviesList()
        fun kill()
    }
}