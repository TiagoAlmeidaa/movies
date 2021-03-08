package com.tiago.model

import java.io.Serializable

data class Movie(
    val id: Long,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Long
) : Serializable