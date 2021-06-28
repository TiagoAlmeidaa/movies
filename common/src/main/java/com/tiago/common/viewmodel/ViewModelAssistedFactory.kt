package com.tiago.common.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T: ViewModel> {
    fun create(state: SavedStateHandle): T
}