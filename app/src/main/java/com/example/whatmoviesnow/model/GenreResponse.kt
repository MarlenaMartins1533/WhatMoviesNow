package com.example.whatmoviesnow.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GenreResponse {

    @SerializedName("genres")
    @Expose
    var genres: MutableList<Genre>? = null
}