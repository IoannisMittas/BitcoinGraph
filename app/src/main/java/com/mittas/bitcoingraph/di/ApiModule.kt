package com.mittas.bitcoingraph.di

import com.mittas.bitcoingraph.data.network.ApiFactories
import com.mittas.bitcoingraph.data.network.Blockchain
import com.mittas.bitcoingraph.data.network.charts.ChartsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideChartsApi(): ChartsApi = ApiFactories.createApi(Blockchain.INFO_ENDPOINT, ChartsApi::class.java)
}