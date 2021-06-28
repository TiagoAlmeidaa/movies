package com.tiago.common.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class ViewModelCreatorFactory<out V : ViewModel>(
    private val factory: ViewModelAssistedFactory<V>,
    owner: SavedStateRegistryOwner,
    bundle: Bundle? = null
): AbstractSavedStateViewModelFactory(owner, bundle) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return factory.create(handle) as T
    }
}