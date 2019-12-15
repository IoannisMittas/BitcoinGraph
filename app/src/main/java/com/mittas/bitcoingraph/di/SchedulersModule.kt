package com.mittas.bitcoingraph.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class SchedulersModule {

    @Provides
    @Named("postScheduler")
    fun providePostScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Named("workScheduler")
    fun provideWorkScheduler(): Scheduler {
        return Schedulers.io()
    }
}