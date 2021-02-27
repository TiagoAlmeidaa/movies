package com.tiago.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
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

    private val _mode =
        MutableLiveData<RecyclerViewState>().apply { value = RecyclerViewState.ListMode() }
    val mode = _mode as LiveData<RecyclerViewState>

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getPopularMovies() {
        _state.postValue(PopularState.OnLoading)

        val disposable = repository
            .getPopularMovies()
            .subscribe(
                { movies -> _state.postValue(PopularState.OnMoviesReceived(movies)) },
                { exception -> _state.postValue(PopularState.OnMoviesFailed(exception)) }
            )

        disposables.add(disposable)
    }

    fun changeRecyclerViewMode() = when (_mode.value) {
        is RecyclerViewState.GridMode -> _mode.postValue(RecyclerViewState.ListMode())
        is RecyclerViewState.ListMode -> _mode.postValue(RecyclerViewState.GridMode())
        null -> _mode.postValue(RecyclerViewState.ListMode())
    }

    fun hasMovies(): Boolean = _state.value is PopularState.OnMoviesReceived

}