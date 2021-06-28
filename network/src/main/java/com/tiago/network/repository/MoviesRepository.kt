package com.tiago.network.repository

import com.tiago.model.ApiResponse
import io.reactivex.rxjava3.core.Observable

interface MoviesRepository {
    fun getPopularMovies(page: Int): Observable<ApiResponse>
}