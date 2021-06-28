package com.tiago.popular.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tiago.model.Movie
import com.tiago.network.util.Urls
import com.tiago.popular.databinding.AdapterMovieBinding

class MovieAdapterViewHolder(
    private val binding: AdapterMovieBinding,
    private val events: MovieAdapterEvents
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) = with(binding) {
        itemView.setOnClickListener {
            events.onMovieClicked(movie, ivPoster)
        }

        Glide
            .with(root)
            .load("${Urls.posterUrl()}${movie.posterPath}")
            .into(ivPoster)
    }

}