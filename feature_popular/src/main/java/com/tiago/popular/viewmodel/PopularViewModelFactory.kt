package com.tiago.popular.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.tiago.common.viewmodel.ViewModelAssistedFactory
import com.tiago.network.repository.MoviesRepository
import javax.inject.Inject

class PopularViewModelFactory @Inject constructor(
    private val repository: MoviesRepository
): ViewModelAssistedFactory<PopularViewModel> {
    override fun create(state: SavedStateHandle): PopularViewModel =
        PopularViewModel(state, repository)
}