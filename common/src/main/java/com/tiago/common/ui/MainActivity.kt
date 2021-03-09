package com.tiago.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.tiago.common.databinding.ActivityMainBinding
import com.tiago.navigation.MoviesNavigation
import com.tiago.navigation.MoviesNavigator
import com.tiago.navigation.Navigator

class MainActivity : AppCompatActivity(), Navigator {

    private val binding: ActivityMainBinding by lazy {
        initializeBinding()
    }

    private val navigator: MoviesNavigator by lazy {
        initializeNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun navigateTo(navigation: MoviesNavigation) {
        navigator.navigate(navigation)
    }

    private fun initializeBinding() = ActivityMainBinding.inflate(layoutInflater).apply {
        lifecycleOwner = this@MainActivity
    }

    private fun initializeNavigator() = MoviesNavigator().apply {
        val navHost = supportFragmentManager.findFragmentById(binding.fragmentContainer.id) as NavHostFragment
        navController = navHost.navController
    }

}