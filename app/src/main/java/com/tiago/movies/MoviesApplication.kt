package com.tiago.movies

import android.app.Application
import com.tiago.movies.di.AppComponent
import com.tiago.movies.di.DaggerAppComponent
import com.tiago.network.di.DaggerNetworkComponent

class MoviesApplication : Application() {
    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .networkComponent(DaggerNetworkComponent.builder().build())
        .build()
}