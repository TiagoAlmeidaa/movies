package com.tiago.movies

import android.app.Application
import com.tiago.movies.di.AppComponent
import com.tiago.movies.di.DaggerAppComponent

class MoviesApplication : Application() {
    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .build()
}