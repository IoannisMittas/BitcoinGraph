package com.mittas.bitcoingraph.data.utils

fun Int.weeksQueryParam(): String? {
    return if (this > 0) "${this}weeks" else null
}

fun Int.monthsQueryParam(): String? {
    return if (this > 0) "${this}months" else null
}

fun Int.yearsQueryParam(): String? {
    return if (this > 0) "${this}years" else null
}
