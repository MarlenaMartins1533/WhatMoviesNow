package com.example.whatmoviesnow.core

import android.app.Application
import com.example.whatmoviesnow.service.MovieClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        MovieClient.initialize()
    }
}