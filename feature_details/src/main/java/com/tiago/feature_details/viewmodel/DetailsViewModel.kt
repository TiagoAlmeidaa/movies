package com.tiago.feature_details.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tiago.common.util.BundleKeys
import com.tiago.feature_details.model.DetailsState
import com.tiago.model.Movie

internal class DetailsViewModel : ViewModel() {

    private val _state = MutableLiveData<DetailsState>()
    val state = _state as LiveData<DetailsState>

    fun getMovieFrom(bundle: Bundle?) {
        val movie = bundle?.getSerializable(BundleKeys.BUNDLE_DETAILS) as Movie?
        val state = if (movie == null) {
            DetailsState.OnMovieNotFound
        } else {
            DetailsState.OnMovieReceived(movie)
        }
        _state.postValue(state)
    }
}