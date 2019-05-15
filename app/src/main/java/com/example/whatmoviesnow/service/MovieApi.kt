package com.example.whatmoviesnow.service

import com.example.whatmoviesnow.model.GenreResponse
import com.example.whatmoviesnow.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

        @GET("movie/popular")
        fun getPopularMovies(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page")page: Int): Call<MovieResponse>

        @GET("genre/movie/list")
        fun getGenres(
            @Query("api_key") apiKey: String): Call<GenreResponse>
}