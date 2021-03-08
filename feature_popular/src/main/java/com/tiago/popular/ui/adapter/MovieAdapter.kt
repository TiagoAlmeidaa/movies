package com.tiago.popular.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tiago.model.Movie
import com.tiago.popular.R
import com.tiago.popular.databinding.AdapterMovieBinding

internal class MovieAdapter(
    private val events: MovieAdapterEvents
) : RecyclerView.Adapter<MovieAdapterViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    init {
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MovieAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapterViewHolder, position: Int) = with(holder) {
        val movie = movies[position]
        bind(movie)
        itemView.setOnClickListener { events.onMovieClicked(movie) }
    }

    override fun getItemCount(): Int = movies.size

    fun addMovies(newMovies: List<Movie>) {
        val oldValue = movies.size
        val newValue = newMovies.size

        movies.addAll(newMovies)

        notifyItemRangeInserted(oldValue, newValue)
    }

}