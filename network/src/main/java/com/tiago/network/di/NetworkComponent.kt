package com.tiago.network.di

import com.tiago.network.datasource.MoviesDataSource
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun getMovieDataSource(): MoviesDataSource
}