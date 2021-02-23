package com.tiago.movies.di

import com.tiago.movies.MainActivity
import com.tiago.network.di.NetworkComponent
import dagger.Component
import okhttp3.OkHttpClient

@MainActivityScope
@Component(
    dependencies = [NetworkComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}