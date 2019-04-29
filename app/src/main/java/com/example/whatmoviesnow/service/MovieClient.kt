package com.example.whatmoviesnow.service

import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.MovieResponse
import com.example.whatmoviesnow.scenes.Scenes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class MovieClient () {

    private lateinit var retrofit: MovieApi

    private fun MovieClient (api_key: MovieApi) {

        this.api = MovieApi

        fun getMovies(callback: Scenes) {
            api.getPopularMovies(Constants.AppId, 1)
                .enqueue(object : Callback<MovieResponse>() {
                    fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                        if (response.isSuccessful()) {
                            val MovieResponse = response.body()
                            if (MovieResponse != null && MovieResponse!!.getMovies() != null) {
                                callback.onSuccess(MovieResponse!!.getMovies())
                            } else {
                                callback.onError()
                            }
                        } else {
                            callback.onError()
                        }
                    }

                    fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        callback.onError()
                    }
                })
        }

    }
        companion object {
            lateinit var instance: MovieClient
                private set

            fun initialize(): MovieClient {
                instance = MovieClient()
                instance.retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieApi::class.java)

                instance = MovieClient(retrofit.create(MovieApi::class.java))
                return instance
            }

        }
}