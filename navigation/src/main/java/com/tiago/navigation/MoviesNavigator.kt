package com.tiago.navigation

import androidx.navigation.NavController

class MoviesNavigator {
    lateinit var navController: NavController

    fun navigate(navigation: MoviesNavigation) = when(navigation) {
        MoviesNavigation.Popular -> navController.navigate()
    }
}