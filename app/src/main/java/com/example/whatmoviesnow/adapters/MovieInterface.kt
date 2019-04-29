package com.example.whatmoviesnow.adapters

import android.content.Context

interface MovieInterface {

    interface View {
        fun getContext(): Context?
    }
    interface Presenter {}
}