package com.mittas.bitcoingraph.domain.entity.blockchain.charts

data class MarketPriceChart(
    override val status: String?,
    override val name: String?,
    override val unit: String?,
    override val period: String?,
    override val description: String?,
    override val values: List<ValuePair>?
) : BaseChart()