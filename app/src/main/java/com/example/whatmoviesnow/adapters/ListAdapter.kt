package com.example.whatmoviesnow.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class ListAdapter (private val movies: List<Movie>, //pegar dependendo da tab(action,drama...)
                   private val movieView: MovieInterface.View
) : Adapter<ListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = movies[position]
        holder.bindView(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(movieView.getContext()).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(movie: Movie) {
            itemView.movie_titleTXT.text = movie.title
            Picasso.get().load(Constants.imageUrl + movie.posterPath).into(itemView.image_movieIMG)

//          itemView.itemCV.setOnClickListener {
//                if (!movie.seeDetails) {
//
//                   // itemView.movie_descriptionTXT.visibility = View.VISIBLE
//                    movie.seeDetails = true
////                } else { movie.seeDetails = false
////                    itemView.movie_descriptionTXT.visibility = View.GONE
//                  }
        }
    }
}