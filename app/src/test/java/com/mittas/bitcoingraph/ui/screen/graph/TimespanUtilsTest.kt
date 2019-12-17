package com.mittas.bitcoingraph.ui.screen.graph

import org.junit.Assert
import org.junit.Test

class TimespanUtilsTest {

    @Test
    fun testTimespanForPosition() {
        Assert.assertEquals(null, (-5).timespanForPosition())
        Assert.assertEquals(null, 1585.timespanForPosition())
        Assert.assertEquals(Timespan.WEEK, 0.timespanForPosition())
        Assert.assertEquals(Timespan.MONTH, 1.timespanForPosition())
        Assert.assertEquals(Timespan.YEAR, 2.timespanForPosition())
    }

}