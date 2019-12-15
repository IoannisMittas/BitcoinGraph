package com.mittas.bitcoingraph.domain.usecases

import io.reactivex.Scheduler

abstract class BaseUseCase {
    abstract val workScheduler: Scheduler
    abstract val postScheduler: Scheduler
}

