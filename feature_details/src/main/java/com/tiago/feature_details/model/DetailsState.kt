package com.tiago.feature_details.model

import com.tiago.model.Movie

internal sealed class DetailsState {
    data class OnMovieReceived(val movie: Movie) : DetailsState()
    object OnMovieNotFound : DetailsState()
}