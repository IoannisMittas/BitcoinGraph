package com.mittas.bitcoingraph.data.repositories.blockchain.charts

import com.mittas.bitcoingraph.data.network.blockchain.charts.ChartsApi
import com.mittas.bitcoingraph.domain.entity.blockchain.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.repository.blockchain.charts.ChartsRepository
import com.mittas.bitcoingraph.domain.repository.blockchain.charts.MarketPriceChartParams
import io.reactivex.Observable
import javax.inject.Inject

class ChartsRepositoryImpl @Inject constructor(private val chartsApi: ChartsApi): ChartsRepository {

    override fun getMarketPriceChart(params: MarketPriceChartParams): Observable<MarketPriceChart> {
        return with(params) {
            chartsApi.getMarketPriceChart(
                timespan,
                rollingAverage,
                start,
                format,
                sampled
            )
        }
    }
}