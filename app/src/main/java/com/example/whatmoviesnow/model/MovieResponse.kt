package com.example.whatmoviesnow.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MovieResponse {

    @SerializedName("list_Movies")
    @Expose
    private var movies: List<Movie>? = null

}