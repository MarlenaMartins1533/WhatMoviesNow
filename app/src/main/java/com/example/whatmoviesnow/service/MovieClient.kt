package com.example.whatmoviesnow.service

import android.util.Log
import com.example.whatmoviesnow.data.Constants
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

    fun getPopularMovies(apiKey: String, language: String, page: Int): MovieResponse? {
        val call = retrofit.getPopularMovies("b7998e0023a9f2977d5569934f9d82f1", "LANGUAGE", 1)

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
}