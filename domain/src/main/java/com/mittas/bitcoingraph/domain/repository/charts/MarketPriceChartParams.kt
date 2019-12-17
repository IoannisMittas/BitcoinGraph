package com.mittas.bitcoingraph.domain.repository.charts

data class MarketPriceChartParams(
override var timespan: String? = null,
override var rollingAverage: String? = null,
override var start: Double? = null,
override var format: String? = null,
override var sampled: Boolean? = null
) : BaseChartParams()