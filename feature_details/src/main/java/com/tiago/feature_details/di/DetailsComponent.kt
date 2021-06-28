package com.tiago.feature_details.di

import com.tiago.common.di.FragmentScope
import com.tiago.feature_details.ui.DetailsFragment
import dagger.Component

@FragmentScope
@Component
interface DetailsComponent {
    fun inject(fragment: DetailsFragment)
}