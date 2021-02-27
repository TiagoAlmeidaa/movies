package com.tiago.popular.model

sealed class PopularState {
    data class OnMoviesReceived(val json: String) : PopularState()
    data class OnMoviesFailed(val exception: Throwable) : PopularState()
}