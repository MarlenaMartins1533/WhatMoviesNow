package com.example.whatmoviesnow.scenes.fantasyList

import com.example.whatmoviesnow.model.Movie
import com.example.whatmoviesnow.scenes.Scenes


interface FantasyList {

    interface View: Scenes.View {
        fun setList(fantasyList: MutableList<Movie>?)
    }

    interface Presenter: Scenes.Presenter {
        fun getList(): MutableList<Movie>
        fun kill()
    }
}