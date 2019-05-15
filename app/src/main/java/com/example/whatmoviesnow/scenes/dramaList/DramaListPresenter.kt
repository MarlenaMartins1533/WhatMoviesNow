package com.example.whatmoviesnow.scenes.dramaList

import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DramaListPresenter (val view:DramaList.View): DramaList.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null


    override fun getList(): MutableList<Movie> {
        val dramaList = mutableListOf<Movie>()

        Cache.movieList.forEach{ movie ->
            movie.genreIds?.forEach{ id ->
                if (id == Cache.dramaId) {
                    dramaList.add(movie)
                }
            }
        }
        return dramaList

    }

    override fun kill(){
        job?.cancel()
    }
}

