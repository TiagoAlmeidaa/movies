package com.tiago.popular.di

import com.tiago.common.MoviesApplication

internal object PopularInjector {
    val component: PopularComponent = DaggerPopularComponent
        .builder()
        .networkComponent(MoviesApplication.networkComponent)
        .build()
}