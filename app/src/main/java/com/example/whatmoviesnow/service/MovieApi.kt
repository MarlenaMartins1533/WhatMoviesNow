package com.example.whatmoviesnow.service

import com.example.whatmoviesnow.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

        @GET("movie/popular")

        fun getMovies(
            @Query("api_key") apiKey: String,
            @Query("gender") gender: String): Call<MovieResponse>


        @GET("genre/movie/list")

        fun getGenre(
            @Query("api_key") apiKey: String): Call<MovieResponse>
}