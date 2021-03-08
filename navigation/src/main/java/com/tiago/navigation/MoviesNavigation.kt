package com.tiago.navigation

import android.os.Bundle

sealed class MoviesNavigation {
    data class Details(val bundle: Bundle) : MoviesNavigation()
}