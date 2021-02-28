package com.tiago.popular.model

import com.tiago.popular.R
import com.tiago.common.util.decoration.GridItemDecoration
import com.tiago.common.util.decoration.ListItemDecoration

sealed class RecyclerViewState {
    data class GridMode(
        val iconChangeTo: Int = R.drawable.icon_view_list,
        val decoration: GridItemDecoration = GridItemDecoration()
    ) : RecyclerViewState()
    data class ListMode(
        val iconChangeTo: Int = R.drawable.icon_view_grid,
        val decoration: ListItemDecoration = ListItemDecoration()
    ) : RecyclerViewState()
}