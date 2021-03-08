package com.tiago.feature_details.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.tiago.common.viewmodel.ViewModelAssistedFactory
import javax.inject.Inject

internal class DetailsViewModelFactory @Inject constructor() :
    ViewModelAssistedFactory<DetailsViewModel> {
    override fun create(state: SavedStateHandle): DetailsViewModel = DetailsViewModel()
}