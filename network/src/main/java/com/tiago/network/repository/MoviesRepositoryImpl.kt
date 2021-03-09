package com.tiago.network.repository

import com.tiago.model.Movie
import com.tiago.network.datasource.MoviesDataSource
import com.tiago.network.util.Keys
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

internal class MoviesRepositoryImpl @Inject constructor(
    private val dataSource: MoviesDataSource
) : MoviesRepository {

    override fun getPopularMovies(page: Int): Observable<List<Movie>> =
        dataSource
            .getPopularMovies(Keys.apiKey(), page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response -> response.results }
            .toObservable()
}