package com.mittas.bitcoingraph.domain.repository.charts

abstract class BaseChartParams{
    abstract val timespan: String?
    abstract val rollingAverage: String?
    abstract val start: Double?
    abstract val format: String?
    abstract val sampled: Boolean?
}
