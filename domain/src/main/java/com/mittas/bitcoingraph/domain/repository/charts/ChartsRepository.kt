package com.mittas.bitcoingraph.domain.repository.charts

import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import io.reactivex.Observable

interface ChartsRepository {

    fun getMarketPriceChart(params: MarketPriceChartParams): Observable<MarketPriceChart>
}