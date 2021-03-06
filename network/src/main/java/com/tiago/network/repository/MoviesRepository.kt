package com.tiago.network.repository

import com.tiago.model.Movie
import io.reactivex.rxjava3.core.Observable

interface MoviesRepository {
    fun getPopularMovies(page: Int): Observable<List<Movie>>
}