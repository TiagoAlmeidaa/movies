package com.tiago.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tiago.common.util.SingleLiveEvent
import com.tiago.model.Movie
import com.tiago.model.MoviesBackup
import com.tiago.network.repository.MoviesRepository
import com.tiago.popular.model.PopularState
import com.tiago.popular.ui.adapter.MovieAdapter
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
        if (addPage) currentPage++

        val disposable = repository
            .getPopularMovies(currentPage)
            .subscribe(
                { handleReceivedMovies(it) },
                { handleException(addPage, it) }
            )

        disposables.add(disposable)
    }

    fun handleReceivedMovies(movies: List<Movie>) {
        _backup.page = currentPage
        _backup.movies.addAll(movies)

        _state.postValue(PopularState.OnMoviesReceived(movies))
    }

    fun handleException(addPage: Boolean, exception: Throwable) {
        if (addPage) currentPage--

        _state.postValue(PopularState.OnMoviesFailed(exception))
    }

    fun hasMovies(): Boolean = _backup.movies.isNotEmpty()

    fun restore(adapter: MovieAdapter) {
        currentPage = _backup.page
        adapter.clear()
        _state.postValue(PopularState.OnMoviesReceived(_backup.movies))
    }

}