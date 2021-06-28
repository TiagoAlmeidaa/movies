package com.tiago.model

data class MoviesBackup(
    var page: Int = 1,
    var movies: MutableList<Movie> = mutableListOf()
)