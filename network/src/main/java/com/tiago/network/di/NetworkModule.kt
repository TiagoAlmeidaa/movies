package com.tiago.network.di

import com.tiago.network.datasource.MoviesDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val URL_KEY = "url.key"
    }

    @Provides
    @Named(URL_KEY)
    fun provideUrl(): String {
        return "https://api.themoviedb.org/"
    }

    @Provides
    @Singleton
    fun provideMoviesDataSource(retrofit: Retrofit): MoviesDataSource =
        retrofit
            .create(MoviesDataSource::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(@Named(URL_KEY) url: String): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

}