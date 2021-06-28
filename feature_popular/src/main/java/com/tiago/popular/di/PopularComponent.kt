package com.tiago.popular.di

import com.tiago.common.di.FragmentScope
import com.tiago.network.di.NetworkComponent
import com.tiago.popular.ui.PopularFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [NetworkComponent::class])
interface PopularComponent {
    fun inject(fragment: PopularFragment)
}