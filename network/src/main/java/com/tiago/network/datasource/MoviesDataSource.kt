package com.tiago.network.datasource

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDataSource {

    @GET("3/movie/popular?")
    fun get(@Query("api_key") apiKey: String): Single<String>

}