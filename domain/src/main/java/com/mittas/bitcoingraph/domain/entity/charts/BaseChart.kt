package com.mittas.bitcoingraph.domain.entity.charts

import java.io.Serializable

abstract class BaseChart: Serializable {
    abstract val status: String?
    abstract val name: String?
    abstract val unit: String?
    abstract val period: String?
    abstract val description: String?
    abstract val values: List<ValuePair>?
}



