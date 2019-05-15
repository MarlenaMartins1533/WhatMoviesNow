package com.example.whatmoviesnow.scenes.fantasyList

import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FantasyListPresenter (val view:FantasyList.View): FantasyList.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null


    override fun getList(): MutableList<Movie> {
        val fantasyList = mutableListOf<Movie>()

        Constants.movieList.forEach{ movie ->
            movie.genreIds?.forEach{ id ->
                if (id == Constants.fantasyId) {
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

