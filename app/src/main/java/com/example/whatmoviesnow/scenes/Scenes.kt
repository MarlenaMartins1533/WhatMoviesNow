package com.example.whatmoviesnow.scenes

import android.content.Context
import com.example.whatmoviesnow.model.Movie

interface Scenes { //OnGetMoviesCallback

        interface View {
                fun getViewContext(): Context?
                fun showError(error: String)
        }

        interface Presenter{
//                fun onSuccess(movies: List<Movie>)
                fun onError()
        }
}