package com.tiago.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tiago.common.R
import com.tiago.navigation.MoviesNavigation
import com.tiago.navigation.Navigator

class MainActivity : AppCompatActivity(R.layout.activity_main), Navigator {

    //private val navigator: MoviesNavigator = MoviesNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //navigator.navController = findNavController(R.id.fragment_container)
    }

    override fun navigateTo(navigation: MoviesNavigation) {
        //navigator.navigate(navigation)
    }

}