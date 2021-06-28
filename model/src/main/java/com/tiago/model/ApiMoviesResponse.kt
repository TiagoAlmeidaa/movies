package com.tiago.model

data class ApiMoviesResponse(
    val page: Int,
    val results: List<Movie>
) : ApiResponse()