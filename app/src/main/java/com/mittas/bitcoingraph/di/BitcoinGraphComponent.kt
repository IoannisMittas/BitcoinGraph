package com.mittas.bitcoingraph.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SchedulersModule::class, RepositoriesModule::class, ApiModule::class, ViewModelsModule::class])
interface BitcoinGraphComponent {

}