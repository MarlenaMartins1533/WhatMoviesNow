package com.example.whatmoviesnow.scenes.fictionList

import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.scenes.Scenes


interface FictionList {

    interface View: Scenes.View {
        fun setList(fictionList: MutableList<Movie>?)
    }

    interface Presenter: Scenes.Presenter {
        fun getList(): MutableList<Movie>
        fun kill()
    }
}