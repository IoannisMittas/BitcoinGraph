package com.mittas.bitcoingraph.domain.repository.blockchain.charts

import com.mittas.bitcoingraph.domain.entity.blockchain.charts.AverageBlockSizeChart
import com.mittas.bitcoingraph.domain.entity.blockchain.charts.MarketPriceChart
import com.mittas.bitcoingraph.domain.entity.blockchain.charts.MempoolSizeChart
import com.mittas.bitcoingraph.domain.entity.blockchain.charts.TransactionsPerDayChart
import io.reactivex.Observable

interface ChartsRepository {

    fun getMarketPriceChart(params: MarketPriceChartParams): Observable<MarketPriceChart>

    fun getAverageBlockSizeChart(params: AverageBlockSizeChartParams): Observable<AverageBlockSizeChart>

    fun getTransactionsPerDayChart(params: TransactionsPerDayChartParams): Observable<TransactionsPerDayChart>

    fun getMempoolSizeChart(params: MempoolSizeChartParams): Observable<MempoolSizeChart>
}