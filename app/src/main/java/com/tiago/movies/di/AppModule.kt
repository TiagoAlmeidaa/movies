package com.tiago.movies.di

import com.tiago.network.di.NetworkComponent
import dagger.Module

@Module(subcomponents = [NetworkComponent::class])
class AppModule {

}