package com.example.whatmoviesnow.scenes.actionList

import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.model.Movie

class ActionListPresenter (val view:ActionList.View): ActionList.Presenter {

//    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
//    private var job: Job? = null

//    override fun onSuccess(movies: List<Movie>) {}

    override fun getList() {
        val actionList: ArrayList<Movie> = ArrayList()
        var title = "Velozes e Furiosos"

        arrayListOf(1, "Velozes e Furiosos", "Action")
        arrayListOf(2, "Avengers", "Action")
        arrayListOf(3, "Aposentados e perigosos", "Action")

        //getList no servidor
        view.setList(actionList)
    }

    override fun onError() {
         view.showError(R.string.error01.toString())
    }

    override fun kill(){
//        job?.cancel()
    }
}

