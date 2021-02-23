package com.tiago.network.di

import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [NetworkModule::class])
interface NetworkComponent {

    @Subcomponent.Builder
    interface Builder {
        fun requestModule(module: NetworkModule): Builder
        fun build(): NetworkComponent
    }
}