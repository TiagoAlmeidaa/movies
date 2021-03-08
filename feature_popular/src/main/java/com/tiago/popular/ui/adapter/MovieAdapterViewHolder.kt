package com.tiago.popular.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tiago.model.Movie
import com.tiago.popular.R
import com.tiago.popular.databinding.AdapterMovieBinding

class MovieAdapterViewHolder(private val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        Glide
            .with(binding.root)
            .load("https://image.tmdb.org/t/p/w500${movie.posterPath}") // TODO move url out of here
            .placeholder(R.drawable.icon_poster_place_holder)
            .into(binding.imageViewPoster)
    }
}