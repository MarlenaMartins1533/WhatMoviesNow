package com.example.whatmoviesnow.scenes.fantasyList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatmoviesnow.R

class FantasyListFragment: Fragment() {

    companion object {
        fun newInstance(): FantasyListFragment { return FantasyListFragment() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_fantasy_movies_list, container, false)
    }
}