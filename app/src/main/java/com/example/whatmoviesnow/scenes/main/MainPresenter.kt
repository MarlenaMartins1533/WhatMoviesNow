package com.example.whatmoviesnow.scenes.main

import android.util.Log
import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.service.MovieClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainPresenter (val view: Main.View): Main.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null

    override fun getGenres() {

        job = launch{
            val response = withContext(Dispatchers.IO){ MovieClient.instance.getGenres() }
            view.setGenreList(response)
            Log.d("LENA", response?.genres?.get(0)?.name)
        }
    }

    override fun getMoviesList() {

        job = launch {
            val movieResponse = withContext(Dispatchers.IO) { MovieClient.instance.getPopularMovies(Cache.page) }
            Cache.totalPages = movieResponse?.totalPages

            view.setMoviesList(movieResponse?.movies)
        }
    }

    override fun kill(){
        job?.cancel()
    }
}

