package com.tiago.model

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)