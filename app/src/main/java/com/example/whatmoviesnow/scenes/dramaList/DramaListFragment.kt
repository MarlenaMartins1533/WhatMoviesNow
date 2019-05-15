package com.example.whatmoviesnow.scenes.dramaList

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.adapters.ListAdapter
import com.example.whatmoviesnow.adapters.MovieInterface
import com.example.whatmoviesnow.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_list.*

class DramaListFragment: Fragment(), MovieInterface.View, DramaList.View {

    companion object {
        fun newInstance(dramaId: Int): DramaListFragment { return DramaListFragment() }
    }

    private lateinit var presenter: DramaList.Presenter
    private val dramaList: MutableList<Movie> by lazy { mutableListOf<Movie>() }
    private var adapter: ListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = DramaListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dramaList.addAll(presenter.getList())
        adapter = ListAdapter(dramaList, this)

        val layoutManager = LinearLayoutManager(context)
        listRV?.layoutManager = layoutManager
        listRV.adapter = adapter
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun getViewContext(): Context? {
        return context
    }

    override fun onResume() {
        super.onResume()
        presenter.getList()
    }

    override fun setList(dramaList: MutableList<Movie>?) {
        this.dramaList.clear()
        dramaList?.let {
            this.dramaList.addAll(it)
            adapter?.notifyDataSetChanged()
        }
    }
    override fun onDestroy() {
        presenter.kill()
        super.onDestroy()
    }
}
