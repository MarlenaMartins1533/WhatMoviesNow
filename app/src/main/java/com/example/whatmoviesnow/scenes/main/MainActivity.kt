package com.example.whatmoviesnow.scenes.main

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.Toast
import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.data.Cache
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.GenreResponse
import com.example.whatmoviesnow.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Main.View {

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null
    private lateinit var presenter: Main.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        presenter = MainPresenter(this)
        presenter.getGenres()
//colocar o search


    }

    override fun getViewContext(): Context? {
        return this
    }

    override fun setGenreList(genreList: GenreResponse?) {

        genreList?.genres?.let {
            Cache.genreList.clear()
            Cache.genreList.addAll(it)
        }

         Cache.genreList.forEach {g->
            if (g.name == "Action") Cache.actionId = g.id
            if (g.name == "Drama") Cache.dramaId = g.id
            if (g.name == "Fantasy") Cache.fantasyId = g.id
            if (g.name == "Science Fiction") Cache.fictionId = g.id
        }
        presenter.getMoviesList()
    }

    override fun setMoviesList(movieList: MutableList<Movie>?) {

        loadingPB?.visibility = View.GONE

        movieList?.let {
            Cache.movieList.clear()
            Cache.movieList.addAll(it)
        }
        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)
        container.adapter = sectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.kill()
        super.onDestroy()
    }
}
