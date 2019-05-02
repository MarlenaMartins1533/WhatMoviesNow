package com.example.whatmoviesnow.service
//
//import org.junit.experimental.results.ResultMatchers.isSuccessful
//import android.support.annotation.NonNull
//import com.example.whatmoviesnow.data.Constants
//import com.example.whatmoviesnow.model.Movie
//import com.example.whatmoviesnow.model.MovieResponse
//import com.example.whatmoviesnow.scenes.Scenes
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.Retrofit
//
//
//class MoviesRepository private constructor(private val api: MovieApi) {
//
//    fun getMovies(callback: Scenes.Presenter) {
//        api.getMovies(Constants.AppId, "gender")
//
//            .enqueue(object : Callback<MovieResponse> {
//
//                fun onResponse(call: Callback<MovieResponse>, response: Response<MovieResponse>) {
//                    if (response.isSuccessful()) {
//                        val moviesResponse = response.body()
//                        if (moviesResponse != null && moviesResponse!!.getMovies() != null) {
//                            Call.onSuccess(MovieResponse.getMovies())
//                        } else {
//                            callback.onError()
//                        }
//                    } else {
//                        callback.onError()
//                    }
//                }
//
//                fun onFailure(call: Call<model.MovieResponse>, t: Throwable) {
//                    callback.onError()
//                }
//            })
//    }
//
//    companion object {
//
//        private var repository: MoviesRepository? = null
//
//        val instance: MoviesRepository
//            get() {
//                if (repository == null) {
//                    val retrofit = Retrofit.Builder()
//                        .baseUrl(Constants.BaseUrl)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build()
//
//                    repository = MoviesRepository(retrofit.create<MovieApi>(MovieApi::class.java))
//                }
//
//                return repository
//            }
//    }
//}