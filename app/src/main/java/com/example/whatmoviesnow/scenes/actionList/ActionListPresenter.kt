package com.example.whatmoviesnow.scenes.actionList

import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.model.Movie

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

        //getList no servidor em MovieClient (getMovies) depois filtra por genre
        view.setList(actionList)
    }

    override fun onError() {
         view.showError(R.string.error01.toString())
    }

    override fun kill(){
//        job?.cancel()
    }
}

