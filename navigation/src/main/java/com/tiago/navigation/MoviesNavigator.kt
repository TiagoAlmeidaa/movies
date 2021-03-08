package com.tiago.navigation

import androidx.navigation.NavController

class MoviesNavigator {
    lateinit var navController: NavController

    fun navigate(navigation: MoviesNavigation) = when(navigation) {
        MoviesNavigation.Details -> navController.navigate(R.id.action_popular_to_details)
    }
}