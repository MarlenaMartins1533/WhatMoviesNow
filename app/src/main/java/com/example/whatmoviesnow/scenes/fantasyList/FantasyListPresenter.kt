package com.example.whatmoviesnow.scenes.fantasyList

import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FantasyListPresenter (val view:FantasyList.View): FantasyList.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null


    override fun getList(): MutableList<Movie> {
        val fantasyList = mutableListOf<Movie>()

        Cache.movieList.forEach{ movie ->
            movie.genreIds?.forEach{ id ->
                if (id == Cache.fantasyId) {
                    fantasyList.add(movie)
                }
            }
        }
        return fantasyList

    }

    override fun kill(){
        job?.cancel()
    }
}

