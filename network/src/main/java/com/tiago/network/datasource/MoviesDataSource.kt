package com.tiago.network.datasource

import com.tiago.model.ApiMoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MoviesDataSource {

    @GET("3/movie/popular?")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("language") language: String = "en-US"
    ): Single<ApiMoviesResponse>

}