package com.tiago.network

import android.app.Application
import com.tiago.network.di.DaggerNetworkComponent
import com.tiago.network.di.NetworkComponent

class MainApplication : Application() {
    companion object {
        val networkComponent: NetworkComponent by lazy {
            DaggerNetworkComponent.create()
        }
    }
}