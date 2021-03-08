package com.tiago.popular.ui.adapter

import com.tiago.model.Movie

interface MovieAdapterEvents {
    fun onMovieClicked(movie: Movie)
}