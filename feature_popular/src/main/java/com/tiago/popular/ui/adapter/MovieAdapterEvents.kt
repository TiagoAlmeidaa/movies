package com.tiago.popular.ui.adapter

import android.view.View
import com.tiago.model.Movie

interface MovieAdapterEvents {
    fun onMovieClicked(movie: Movie, view: View)
}