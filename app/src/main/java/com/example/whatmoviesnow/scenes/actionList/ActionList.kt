package com.example.whatmoviesnow.scenes.actionList

import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.scenes.Scenes


interface ActionList {

    interface View: Scenes.View {
        fun setList(actionList: MutableList<Movie>?)
    }

    interface Presenter: Scenes.Presenter {
        fun getList()
        fun kill()
    }
}


//
//import android.transition.Scene
//
//interface ActionList {
//    interface View: Scene.View{ }
//
//    interface Presenter: Scene.Presenter{
//        fun getList()
//    }
//}