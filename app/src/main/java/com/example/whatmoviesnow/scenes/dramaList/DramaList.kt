package com.example.whatmoviesnow.scenes.dramaList

import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.scenes.Scenes


interface DramaList {

    interface View: Scenes.View {
        fun setList(dramaList: MutableList<Movie>?)
    }

    interface Presenter: Scenes.Presenter {
        fun getList(): MutableList<Movie>
        fun kill()
    }
}


//
//import android.transition.Scene
//
//interface DramaList {
//    interface View: Scene.View{ }
//
//    interface Presenter: Scene.Presenter{
//        fun getList()
//    }
//}