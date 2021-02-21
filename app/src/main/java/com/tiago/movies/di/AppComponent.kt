package com.tiago.movies.di

import com.tiago.movies.MainActivity
import dagger.Component

@MainActivityScope
@Component(
    //dependencies = [NetworkComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}