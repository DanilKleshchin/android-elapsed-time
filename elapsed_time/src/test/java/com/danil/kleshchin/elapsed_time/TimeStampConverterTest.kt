package com.danil.kleshchin.elapsed_time

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class TimeStampConverterTest {

    @Test
    fun time_stamp_converting_test() {
        val time = "2021-02-25T06:00:08-05:00"
        val expectTime = "25/02/2021 06:00:08"
        val timeStamp = getTimestampFromDateTime(time, pattern_1, Locale.getDefault())
        assertEquals(
            expectTime,
            getDateTimeFromTimestamp(timeStamp, pattern_2, Locale.getDefault())
        )
    }
}
