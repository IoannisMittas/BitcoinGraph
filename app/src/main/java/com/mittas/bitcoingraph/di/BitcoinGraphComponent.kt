package com.mittas.bitcoingraph.di

import com.mittas.bitcoingraph.ui.screen.graph.GraphActivity
import com.mittas.bitcoingraph.ui.screen.graph.GraphFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulersModule::class, RepositoriesModule::class, ApiModule::class, ViewModelsModule::class])
interface BitcoinGraphComponent {
    //todo remove this
    fun inject(activity: GraphActivity)
    fun inject(fragment: GraphFragment)
}