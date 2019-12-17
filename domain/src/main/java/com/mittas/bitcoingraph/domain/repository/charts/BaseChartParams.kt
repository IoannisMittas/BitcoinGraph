package com.mittas.bitcoingraph.domain.repository.charts

abstract class BaseChartParams{
    abstract var timespan: String?
    abstract var rollingAverage: String?
    abstract var start: Double?
    abstract var format: String?
    abstract var sampled: Boolean?
}
