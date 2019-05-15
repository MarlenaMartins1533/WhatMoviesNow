package com.example.whatmoviesnow.scenes.actionList

import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ActionListPresenter (val view:ActionList.View): ActionList.Presenter, CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null


    override fun getList(): MutableList<Movie> {
        val actionList = mutableListOf<Movie>()

        Cache.movieList.forEach{ movie ->
            movie.genreIds?.forEach{ id ->
                if (id == Cache.actionId) {
                    actionList.add(movie)
                }
            }
        }
        return actionList

    }
//        val movie_genre: Int = 1
//        val dramaList: MutableList<Movie> = mutableListOf()
//
//        actionList.add(Movie(1, "Velozes e Furiosos", 1))
//        actionList.add(Movie(2, "Avengers", 1))
//        actionList.add(Movie(3, "Harry Potter", 3))
//        actionList.add(Movie(4, "Meu namorado um zumbi", 2))
//        actionList.add(Movie(5, "Doctor Estranho",1))
//        actionList.add(Movie(6, "Avatar", 4))
//        actionList.add(Movie(7, "Blade", 1))

//        //getList no servidor em MovieClient (getMovies) depois filtra por genre
//
////        actionList.forEach { m ->
////            m.genreIds
////        }
//
////        val result = actionList.filter { m -> m.genreIds == 1 }
//
//        view.setList(actionList)
//    }

    override fun kill(){
        job?.cancel()
    }
}

