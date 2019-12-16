package com.mittas.bitcoingraph.domain.usecases.charts

import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.repository.charts.ChartsRepository
import com.mittas.bitcoingraph.domain.repository.charts.MarketPriceChartParams
import com.mittas.bitcoingraph.domain.usecases.BaseUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler

import javax.inject.Inject
import javax.inject.Named

class GetMarketPriceChartUseCase @Inject constructor(
    val chartsRepository: ChartsRepository,
    @Named("workScheduler") override val workScheduler: Scheduler,
    @Named("postScheduler") override val postScheduler: Scheduler
) : BaseUseCase() {

    fun getChart(params: MarketPriceChartParams): Observable<MarketPriceChart> =
        chartsRepository.getMarketPriceChart(params)
            .subscribeOn(workScheduler)
            .observeOn(postScheduler)
}