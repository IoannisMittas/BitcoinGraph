package com.mittas.bitcoingraph.data.network.charts

import com.mittas.bitcoingraph.domain.entity.charts.MarketPriceChart
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ChartsApi {

    @GET("market-price")
    fun getMarketPriceChart(
        @Query("timespan") timespan: String?,
        @Query("rollingAverage") rollingAverage: String?,
        @Query("start") start: Double?,
        @Query("format") format: String?,
        @Query("sampled") sampled: Boolean?
    ): Observable<MarketPriceChart>
}