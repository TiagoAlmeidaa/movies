package com.tiago.popular.model

import com.tiago.model.Movie

data class MoviesBackupState(
    var page: Int = 1,
    var movies: MutableList<Movie> = mutableListOf()
)