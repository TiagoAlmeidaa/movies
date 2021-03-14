package com.tiago.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tiago.common.R
import com.tiago.common.databinding.ActivityMainBinding
import com.tiago.navigation.MoviesNavigation
import com.tiago.navigation.MoviesNavigator
import com.tiago.navigation.Navigator

class MainActivity : AppCompatActivity(R.layout.activity_main), Navigator {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val navigator: MoviesNavigator by lazy {
        initializeNavigator()
    }

    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.fragmentContainer.id) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun navigateTo(navigation: MoviesNavigation) {
        navigator.navigate(navigation)
    }

    private fun initializeNavigator() = MoviesNavigator().apply {
        navController = navHostFragment.navController
    }

}