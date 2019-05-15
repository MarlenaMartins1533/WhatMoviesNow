package com.example.whatmoviesnow.scenes.fictionList

import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FictionListPresenter (val view:FictionList.View): FictionList.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null


    override fun getList(): MutableList<Movie> {
        val fictionList = mutableListOf<Movie>()

        Cache.movieList.forEach{ movie ->
            movie.genreIds?.forEach{ id ->
                if (id == Cache.fictionId) {
                    fictionList.add(movie)
                }
            }
        }
        return fictionList

    }

    override fun kill(){
        job?.cancel()
    }
}

