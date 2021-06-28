package com.tiago.common

import android.app.Application
import com.tiago.network.di.DaggerNetworkComponent
import com.tiago.network.di.NetworkComponent

class MoviesApplication : Application() {
    companion object {
        val networkComponent: NetworkComponent by lazy {
            DaggerNetworkComponent.create()
        }
    }
}