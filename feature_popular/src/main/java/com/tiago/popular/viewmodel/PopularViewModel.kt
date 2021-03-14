package com.tiago.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tiago.common.util.SingleLiveEvent
import com.tiago.model.ApiErrorResponse
import com.tiago.model.ApiMoviesResponse
import com.tiago.model.MoviesBackup
import com.tiago.network.repository.MoviesRepository
import com.tiago.popular.model.PopularState
import io.reactivex.rxjava3.disposables.CompositeDisposable

internal class PopularViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private val _state = SingleLiveEvent<PopularState>()
    val state = _state as LiveData<PopularState>

    private var currentPage = 1
    private var _backup: MoviesBackup = MoviesBackup()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getPopularMovies(addPage: Boolean = false) {
        val page = if (addPage)
            currentPage + 1
        else
            currentPage

        disposables.add(
            repository
                .getPopularMovies(page)
                .subscribe { response ->
                    when(response) {
                        is ApiMoviesResponse -> handleReceivedMovies(response)
                        is ApiErrorResponse -> _state.postValue(PopularState.FetchFailed(response))
                        else -> _state.postValue(PopularState.InvalidResponse)
                    }
                }
        )
    }

    fun handleReceivedMovies(response: ApiMoviesResponse) = with(response) {
        currentPage = page

        _backup.page = currentPage
        _backup.movies.addAll(results)

        _state.postValue(PopularState.FetchSucceeded(results))
    }

    fun hasMovies(): Boolean = _backup.movies.isNotEmpty()

    fun restore() {
        currentPage = _backup.page
        _state.postValue(PopularState.FetchSucceeded(_backup.movies))
    }

}