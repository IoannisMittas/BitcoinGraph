package com.mittas.bitcoingraph.di

import com.mittas.bitcoingraph.ui.screen.graph.GraphActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulersModule::class, RepositoriesModule::class, ApiModule::class, ViewModelsModule::class])
interface BitcoinGraphComponent {
    fun inject(activity: GraphActivity)
}