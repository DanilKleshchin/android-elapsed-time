package com.danil.kleshchin.elapsed_time

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * An util file for converting date time to timestamp and vice versa.
 */

const val UNKNOWN_TIME = -1L

//Most commonly used date time formats
const val pattern_1 = "yyyy-MM-dd'T'HH:mm:ss"
const val pattern_2 = "dd/MM/yyyy HH:mm:ss"
const val pattern_3 = "EEE, dd MMM yyyy HH:mm:ss Z"
const val pattern_4 = "EEE, yyyy-MM-dd HH:mm"
const val pattern_5 = "yyyy/MM/dd HH:mm"
const val pattern_6 = "yyyy-MM-dd HH:mm:ss"
const val pattern_7 = "dd-MM-yyyy HH:mm:ss"
const val pattern_8 = "EEE, dd MMM yyyy HH:mm:ss"

const val GMT_TIME_ZONE = "GMT"


fun getTimestampFromDateTime(
    dateTime: String,
    dateTimePattern: String,
    timeZone: TimeZone = TimeZone.getTimeZone(GMT_TIME_ZONE),
    locale: Locale
): Long {
    return try {
        val timeFormat = SimpleDateFormat(dateTimePattern, locale)
        timeFormat.timeZone = timeZone
        timeFormat.parse(dateTime)?.time ?: UNKNOWN_TIME
    } catch (e: ParseException) {
        UNKNOWN_TIME
    }
}

fun getDateTimeFromTimestamp(
    timeStamp: Long,
    dateTimePattern: String,
    timeZone: TimeZone = TimeZone.getDefault(),
    locale: Locale
): String {
    val timeFormat = SimpleDateFormat(dateTimePattern, locale)
    timeFormat.timeZone = timeZone
    return timeFormat.format(Date(timeStamp))
}
