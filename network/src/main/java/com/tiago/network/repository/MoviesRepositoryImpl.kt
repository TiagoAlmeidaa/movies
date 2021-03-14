package com.tiago.network.repository

import com.tiago.model.ApiErrorResponse
import com.tiago.model.ApiResponse
import com.tiago.network.datasource.MoviesDataSource
import com.tiago.network.util.Constants
import com.tiago.network.util.HttpCodes
import com.tiago.network.util.Keys
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Named

internal class MoviesRepositoryImpl @Inject constructor(
    private val dataSource: MoviesDataSource,
    @Named(Constants.NAMED_API_KEY) private val apiKey: String
) : MoviesRepository {

    override fun getPopularMovies(page: Int): Observable<ApiResponse> =
        dataSource
            .getPopularMovies(apiKey, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { response ->
                response as ApiResponse
            }
            .onErrorReturn { exception ->
                when (exception) {
                    is UnknownHostException -> ApiErrorResponse.ConnectionError
                    is HttpException -> when (exception.code()) {
                        HttpCodes.NOT_FOUND -> ApiErrorResponse.NotFoundError
                        HttpCodes.INTERNAL -> ApiErrorResponse.InternalError
                        else -> ApiErrorResponse.ExceptionNotMapped
                    }
                    else -> ApiErrorResponse.ExceptionNotMapped
                }
            }
            .toObservable()
}