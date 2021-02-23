package com.tiago.network.repository

import com.tiago.network.datasource.MoviesDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val dataSource: MoviesDataSource
) {

    companion object {
        private const val API_TOKEN = "68ae6fca863e1c90e9d1b1d11492af3d"
    }

    fun get(): Single<String> =
        dataSource
            .get(API_TOKEN)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}