package com.mittas.bitcoingraph.di

import com.mittas.bitcoingraph.data.repositories.charts.ChartsRepositoryImpl
import com.mittas.bitcoingraph.domain.repository.charts.ChartsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun bindChartsRepository(chartsRepository: ChartsRepositoryImpl): ChartsRepository
}