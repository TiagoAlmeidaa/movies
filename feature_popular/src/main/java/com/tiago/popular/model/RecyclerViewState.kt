package com.tiago.popular.model

import com.tiago.popular.R
import com.tiago.popular.ui.adapter.MovieGridItemDecoration
import com.tiago.popular.ui.adapter.MovieListItemDecoration

sealed class RecyclerViewState {
    data class GridMode(
        val iconChangeTo: Int = R.drawable.icon_view_list,
        val decoration: MovieGridItemDecoration = MovieGridItemDecoration()
    ) : RecyclerViewState()
    data class ListMode(
        val iconChangeTo: Int = R.drawable.icon_view_grid,
        val decoration: MovieListItemDecoration = MovieListItemDecoration()
    ) : RecyclerViewState()
}