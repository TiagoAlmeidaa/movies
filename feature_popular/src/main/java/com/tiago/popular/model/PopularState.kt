package com.tiago.popular.model

import com.tiago.model.ApiErrorResponse
import com.tiago.model.Movie

internal sealed class PopularState {
    data class FetchSucceeded(val movies: List<Movie>) : PopularState()
    data class FetchFailed(val error: ApiErrorResponse) : PopularState()
    object InvalidResponse : PopularState()
}