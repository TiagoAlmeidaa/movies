package com.tiago.movies.di

import com.tiago.network.di.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = [AppModule::class])
interface AppComponent {
}