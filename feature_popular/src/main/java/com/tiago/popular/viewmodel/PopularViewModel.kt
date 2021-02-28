package com.tiago.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tiago.model.Movie
import com.tiago.network.repository.MoviesRepository
import com.tiago.popular.model.PopularState
import com.tiago.popular.model.RecyclerViewState
import io.reactivex.rxjava3.disposables.CompositeDisposable

class PopularViewModel(
    private val handler: SavedStateHandle,
    private val repository: MoviesRepository
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private val _state = MutableLiveData<PopularState>()
    val state = _state as LiveData<PopularState>

    private val _mode = MutableLiveData<RecyclerViewState>().apply { value = RecyclerViewState.GridMode() }
    val mode = _mode as LiveData<RecyclerViewState>

    var currentPage = 1
        private set

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
        _state.postValue(PopularState.OnMoviesReceived(movies))
    }

    fun handleException(addPage: Boolean, exception: Throwable) {
        if (addPage) currentPage--

        _state.postValue(PopularState.OnMoviesFailed(exception))
    }

    fun changeRecyclerViewMode() = when (_mode.value) {
        is RecyclerViewState.GridMode -> _mode.postValue(RecyclerViewState.ListMode())
        is RecyclerViewState.ListMode -> _mode.postValue(RecyclerViewState.GridMode())
        null -> _mode.postValue(RecyclerViewState.ListMode())
    }

    fun hasMovies(): Boolean = _state.value is PopularState.OnMoviesReceived

}