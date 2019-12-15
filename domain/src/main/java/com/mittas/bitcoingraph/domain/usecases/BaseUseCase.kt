package com.mittas.bitcoingraph.domain.usecases

import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

abstract class BaseUseCase @Inject constructor(
    @Named("workScheduler") val workScheduler: Scheduler,
    @Named("postScheduler") val postScheduler: Scheduler
)
