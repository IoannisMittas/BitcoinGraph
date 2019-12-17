package com.mittas.bitcoingraph.ui.screen.graph

enum class Timespan {
    WEEK, MONTH, YEAR
}

fun Int.timespanForPosition(): Timespan? {
    return when (this) {
        0 -> Timespan.WEEK
        1 -> Timespan.MONTH
        2 -> Timespan.YEAR
        else -> null
    }
}