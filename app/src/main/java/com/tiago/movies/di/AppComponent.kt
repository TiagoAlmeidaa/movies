package com.tiago.movies.di

import dagger.Component

@MainActivityScope
@Component(modules = [AppModule::class])
interface AppComponent {
}