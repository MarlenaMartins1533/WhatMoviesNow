package com.example.whatmoviesnow.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MovieResponse {

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("results")
    @Expose
    var movies: MutableList<Movie>? = null
}