package com.tiago.popular.di

import com.tiago.network.di.FragmentScope
import com.tiago.network.di.NetworkComponent
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@FragmentScope
@Component(
    dependencies = [NetworkComponent::class],
    modules = [PopularModule::class]
)
interface PopularComponent {
}