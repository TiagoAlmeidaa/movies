package com.tiago.popular.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tiago.model.Movie
import com.tiago.popular.R
import com.tiago.popular.databinding.AdapterMovieBinding

internal class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    init {
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun addMovies(newMovies: List<Movie>) {
        val oldValue = movies.size
        val newValue = newMovies.size

        movies.addAll(newMovies)

        notifyItemRangeInserted(oldValue, newValue)
    }

    inner class MovieViewHolder(private val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            Glide
                .with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}") // TODO move url out of here
                .placeholder(R.drawable.icon_poster_place_holder)
                .into(binding.imageViewPoster)
        }
    }

}