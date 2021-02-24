package com.tiago.popular.di

import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [PopularModule::class])
interface PopularComponent {
}