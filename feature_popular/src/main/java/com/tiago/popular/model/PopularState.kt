package com.tiago.popular.model

import com.tiago.model.Movie

internal sealed class PopularState {
    data class OnMoviesReceived(val movies: List<Movie>) : PopularState()
    data class OnMoviesFailed(val exception: Throwable) : PopularState()
}