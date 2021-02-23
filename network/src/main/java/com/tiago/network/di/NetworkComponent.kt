package com.tiago.network.di

import com.tiago.network.repository.MoviesRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent {
    fun getMoviesRepository(): MoviesRepository
}