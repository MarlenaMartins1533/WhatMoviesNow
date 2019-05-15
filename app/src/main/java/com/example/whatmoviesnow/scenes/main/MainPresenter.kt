package com.example.whatmoviesnow.scenes.main

import android.util.Log
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
            val moviesList = withContext(Dispatchers.IO) { MovieClient.instance.getPopularMovies(1)?.movies }
//            val totalPages = totalPages
            view.setMoviesList(moviesList)
        }
    }

    override fun kill(){
        job?.cancel()
    }
}

