package com.example.whatmoviesnow.service

import android.util.Log
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.GenreResponse
import com.example.whatmoviesnow.model.MovieResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.io.IOException

class MovieClient {

    companion object {
        lateinit var instance: MovieClient
        private set

        fun initialize() {
            instance = MovieClient()
            instance.retrofit = Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi::class.java)
        }
    }

    private lateinit var retrofit: MovieApi

    fun getPopularMovies(page: Int): MovieResponse? {
        val call = retrofit.getPopularMovies(Constants.AppId, "pt-BR", page)

        try {
            val response = call.execute()
            if (response.isSuccessful) {
                Log.d("LENA", "getMovieData successful: ${response.body()?.toString()}")
                return response.body()
            } else {
                Log.d("LENA", "getMovieData Response Error: ${response.errorBody()?.toString()}")
            }
        } catch (e: IOException) {
            Log.e("LENA", e.message)
        } catch (e: RuntimeException) {
            Log.e("LENA", e.message)
        }
        return null
    }

    fun getGenres(): GenreResponse? {
        val call = retrofit.getGenres(Constants.AppId)

        try {
            val response = call.execute()
            if (response.isSuccessful) {
                Log.d("LENA", "getGenres successful: ${response.body()?.toString()}")
                return response.body()
            } else {
                Log.d("LENA", "getGenres Response Error: ${response.errorBody()?.toString()}")
            }
        } catch (e: IOException) {
            Log.e("LENA", e.message)
        } catch (e: RuntimeException) {
            Log.e("LENA", e.message)
        }
        return null
    }
}