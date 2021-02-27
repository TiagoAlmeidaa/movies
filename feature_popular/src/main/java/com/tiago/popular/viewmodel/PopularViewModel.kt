package com.tiago.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tiago.network.repository.MoviesRepository
import com.tiago.popular.model.PopularState
import io.reactivex.rxjava3.disposables.CompositeDisposable

class PopularViewModel(
    private val handler: SavedStateHandle,
    private val repository: MoviesRepository
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private val _state: MutableLiveData<PopularState> = MutableLiveData()
    val state: LiveData<PopularState> = _state

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getPopularMovies() {
        val disposable = repository
            .getPopularMovies()
            .subscribe(
                { movies -> _state.postValue(PopularState.OnMoviesReceived(movies)) },
                { exception -> _state.postValue(PopularState.OnMoviesFailed(exception)) }
            )

        disposables.add(disposable)
    }

    fun hasMovies(): Boolean = _state.value is PopularState.OnMoviesReceived

}