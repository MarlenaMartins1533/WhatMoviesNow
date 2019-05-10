package com.example.whatmoviesnow.scenes.actionList

import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.service.MovieClient

class ActionListPresenter (val view:ActionList.View): ActionList.Presenter {
    override fun onSuccess(movies: List<Movie>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
//    private var job: Job? = null
//    override fun onSuccess(movies: List<Movie>) {}

    override fun getList() {
//        val actionList = MovieClient.instance.getPopularMovies(Constants.AppId, "ENGLISH", 1)?.movies
//        view.setList(actionList)
//    }
        val movie_genre: Int = 1
        val actionList: MutableList<Movie> = mutableListOf()
        val dramaList: MutableList<Movie> = mutableListOf()

        actionList.add(Movie(1, "Velozes e Furiosos", 1))
        actionList.add(Movie(2, "Avengers", 1))
        actionList.add(Movie(3, "Harry Potter", 3))
        actionList.add(Movie(4, "Meu namorado um zumbi", 2))
        actionList.add(Movie(5, "Doctor Estranho",1))
        actionList.add(Movie(6, "Avatar", 4))
        actionList.add(Movie(7, "Blade", 1))

        //getList no servidor em MovieClient (getMovies) depois filtra por genre

//        actionList.forEach { m ->
//            m.genre_ids
//        }

//        val result = actionList.filter { m -> m.genre_ids == 1 }

        view.setList(actionList)
    }

    override fun onError() {
         view.showError(R.string.error.toString())
    }

    override fun kill(){
//        job?.cancel()
    }
}

