package com.mittas.bitcoingraph.domain.repository.blockchain.charts

data class MempoolSizeChartParams(
    override val timespan: String?,
    override val rollingAverage: String?,
    override val start: Double?,
    override val format: String?,
    override val sampled: Boolean?
) : BaseChartParams()
