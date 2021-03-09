package com.tiago.network.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tiago.network.datasource.MoviesDataSource
import com.tiago.network.repository.MoviesRepository
import com.tiago.network.repository.MoviesRepositoryImpl
import com.tiago.network.util.Urls
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(Urls.apiUrl())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    internal fun provideMoviesDataSource(retrofit: Retrofit): MoviesDataSource =
        retrofit
            .create(MoviesDataSource::class.java)

    @Provides
    @Singleton
    internal fun provideMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository =
        impl

}