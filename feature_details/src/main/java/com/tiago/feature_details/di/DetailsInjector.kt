package com.tiago.feature_details.di

object DetailsInjector {
    val component: DetailsComponent = DaggerDetailsComponent
        .builder()
        .build()
}