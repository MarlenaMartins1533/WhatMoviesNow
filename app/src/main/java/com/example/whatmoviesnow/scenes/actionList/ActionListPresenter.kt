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
        val actionList: MutableList<Movie> = mutableListOf()

        actionList.add(Movie(1, "Velozes e Furiosos"))
        actionList.add(Movie(2, "Avengers"))
        actionList.add(Movie(3, "Aposentados e perigosos"))
        actionList.add(Movie(4, "Blade"))
        actionList.add(Movie(5, "Doctor Estranho"))

        //getList no servidor em MovieClient (getMovies) depois filtra por genre
        view.setList(actionList)
    }

    override fun onError() {
         view.showError(R.string.error.toString())
    }

    override fun kill(){
//        job?.cancel()
    }
}

