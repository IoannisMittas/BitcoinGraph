package com.mittas.bitcoingraph.di

import com.mittas.bitcoingraph.data.repositories.blockchain.charts.ChartsRepositoryImpl
import com.mittas.bitcoingraph.domain.repository.blockchain.charts.ChartsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun bindChartsRepository(chartsRepository: ChartsRepositoryImpl): ChartsRepository
}