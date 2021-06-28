package com.tiago.navigation

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigator

sealed class MoviesNavigation {
    data class Details(
        val bundle: Bundle,
        val extras: FragmentNavigator.Extras
    ) : MoviesNavigation()
}