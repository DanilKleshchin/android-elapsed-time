package com.danil.kleshchin.elapsed_time

import android.content.res.Resources
import androidx.annotation.PluralsRes
import androidx.annotation.VisibleForTesting

const val UNKNOWN_TIME_STRING = ""

const val zeroSeconds = 0L
const val oneSecondSeconds = 1L
const val oneMinuteSeconds = 60L
const val oneHourSeconds = 3600L
const val oneDaySeconds = 86_400L
const val oneWeekSeconds = 604_800L
const val oneMonthSeconds = 2_592_000L
const val oneYearSeconds = 31_556_952L

const val secondsInAlmostOneMinute = 59L
const val secondsInAlmostOneHour = 3599L
const val secondsInAlmostOneDay = 86_399L
const val secondsInAlmostOneWeek = 604_799L
const val secondsInAlmostOneMonth = 2_591_999L
const val secondsInAlmostOneYear = 31_556_953L

/**
 * @param beginTimestamp - The time from which to count in millis.
 * @param endTimestamp - The time to which you need to count in millis. For example, current time in millis.
 * @param resources - Android resources. All strings are stored in the Android plurals res directory.
 * @return the elapsed time string like: 1 hour ago, 2 days ago, 5 month ago, etc.
 */
fun getElapsedTimeString(
    beginTimestamp: Long,
    endTimestamp: Long,
    resources: Resources
): String {
    val difference = (endTimestamp - beginTimestamp) / 1000
    if (difference < zeroSeconds) {
        return UNKNOWN_TIME_STRING
    }

    when (difference) {
        in zeroSeconds..secondsInAlmostOneMinute -> {
            return getSecondsElapsedTime(resources, difference)
        }
        in oneMinuteSeconds..secondsInAlmostOneHour -> {
            return getMinutesElapsedTime(resources, difference)
        }
        in oneHourSeconds..secondsInAlmostOneDay -> {
            return getHourlyElapsedTime(resources, difference)
        }
        in oneDaySeconds..secondsInAlmostOneWeek -> {
            return getDailyElapsedTime(resources, difference)
        }
        in oneWeekSeconds..secondsInAlmostOneMonth -> {
            return getWeeklyElapsedTime(resources, difference)
        }
        in oneMonthSeconds..secondsInAlmostOneYear -> {
            return getMonthlyElapsedTime(resources, difference)
        }
        else -> {
            return getYearlyElapsedTime(resources, difference)
        }
    }
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getSecondsElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneSecondSeconds, R.plurals.second_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getMinutesElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneMinuteSeconds, R.plurals.minute_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getHourlyElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneHourSeconds, R.plurals.hour_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getDailyElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneDaySeconds, R.plurals.day_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getWeeklyElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneWeekSeconds, R.plurals.week_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getMonthlyElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneMonthSeconds, R.plurals.month_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun getYearlyElapsedTime(resources: Resources, timeSeconds: Long): String {
    return countElapsedTimeString(resources, timeSeconds, oneYearSeconds, R.plurals.year_elapsed)
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
fun countElapsedTimeString(
    resources: Resources,
    timeSeconds: Long,
    oneItemSeconds: Long,
    @PluralsRes elapsedStringId: Int
): String {
    val count: Int = (timeSeconds / oneItemSeconds).toInt()
    return resources.getQuantityString(elapsedStringId, count, count)
}
