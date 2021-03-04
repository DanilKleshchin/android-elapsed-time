package com.danil.kleshchin.elapsed_time

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * An util file for converting date time to timestamp and vice versa.
 */

const val UNKNOWN_TIME = -1L

//Most commonly used date time formats
const val pattern_1 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
const val pattern_2 = "dd/MM/yyyy HH:mm:ss"
const val pattern_3 = "EEE, dd MMM yyyy HH:mm:ss Z"
const val pattern_4 = "EEE, yyyy-MM-dd HH:mm"
const val pattern_5 = "yyyy/MM/dd HH:mm"
const val pattern_6 = "EEE, dd MMM yyyy HH:mm:ss"


fun getTimestampFromDateTime(dateTime: String, dateTimePattern: String, locale: Locale): Long {
    return try {
        val timeFormat = SimpleDateFormat(dateTimePattern, locale)
        timeFormat.parse(dateTime)?.time ?: UNKNOWN_TIME
    } catch (e: ParseException) {
        UNKNOWN_TIME
    }
}

fun getDateTimeFromTimestamp(timeStamp: Long, dateTimePattern: String, locale: Locale): String {
    val timeFormat = SimpleDateFormat(dateTimePattern, locale)
    return timeFormat.format(Date(timeStamp))
}
