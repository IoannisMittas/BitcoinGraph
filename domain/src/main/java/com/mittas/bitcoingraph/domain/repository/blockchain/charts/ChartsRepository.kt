package com.mittas.bitcoingraph.domain.repository.blockchain.charts

import com.mittas.bitcoingraph.domain.entity.blockchain.charts.MarketPriceChart
import io.reactivex.Observable

interface ChartsRepository {

    fun getMarketPriceChart(params: MarketPriceChartParams): Observable<MarketPriceChart>
}