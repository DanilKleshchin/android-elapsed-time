package com.danil.kleshchin.elapsed_time

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Locale
import java.util.TimeZone

@RunWith(AndroidJUnit4::class)
class ElapsedTimeEnglishTest {

    private lateinit var resources: Resources
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().context
        setEnglishLocale()
        resources = context.resources
    }

    @Test
    fun elapsed_time_test() {
        val time = "2021-03-03T22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_1,
            locale = Locale.getDefault()
        )

        val currentTime =
            getTimestampFromDateTime(
                dateTime = "2021-03-04T22:13:08",
                dateTimePattern = pattern_1,
                locale = Locale.getDefault()
            )
        val expect = "1 day ago"

        val currentTime23 =
            getTimestampFromDateTime(
                dateTime = "2021-03-04T22:13:05",
                dateTimePattern = pattern_1,
                locale = Locale.getDefault()
            )
        val expect23 = "23 hours ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTime,
                resources
            )
        )
        Assert.assertEquals(
            expect23,
            getElapsedTimeString(
                timeStamp,
                currentTime23,
                resources
            )
        )
    }

    @Test
    fun time_zone_test() {
        val time = "03/03/2021 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault(),
            timeZone = TimeZone.getTimeZone("GMT+4") //timezone is optional. Default is GMT
        )

        val currentTime = "03/03/2021 18:13:10"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault(),
            )
        val expect = "2 seconds ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun one_year_ago_test() {
        val time = "28/02/2019 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "28/02/2020 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "1 year ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun two_years_ago_test() {
        val time = "03-03-2019 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_7,
            locale = Locale.getDefault()
        )

        val currentTime = "03-03-2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_7,
                locale = Locale.getDefault()
            )
        val expect = "2 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun three_years_ago_test() {
        val time = "03/03/2018 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "3 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun four_years_ago_test() {
        val time = "03/03/2017 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "4 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun five_years_ago_test() {
        val time = "03/03/2016 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "5 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun ten_years_ago_test() {
        val time = "03/03/2011 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "10 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun twenty_years_ago_test() {
        val time = "03/03/2001 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "20 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun fifty_years_ago_test() {
        val time = "03/03/1971 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2021 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "50 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun hundred_years_ago_test() {
        val time = "03/03/1971 22:13:08"
        val timeStamp = getTimestampFromDateTime(
            dateTime = time,
            dateTimePattern = pattern_2,
            locale = Locale.getDefault()
        )

        val currentTime = "03/03/2071 22:13:08"
        val currentTimestamp =
            getTimestampFromDateTime(
                dateTime = currentTime,
                dateTimePattern = pattern_2,
                locale = Locale.getDefault()
            )
        val expect = "100 years ago"

        Assert.assertEquals(
            expect,
            getElapsedTimeString(
                timeStamp,
                currentTimestamp,
                resources
            )
        )
    }

    @Test
    fun elapsed_seconds_test() {
        val timeSecond = 1L
        val expectSecond = "1 second ago"
        val time30Seconds = 30L
        val expect30Seconds = "30 seconds ago"
        val time59Seconds = 59L // almost 60 seconds (1 minute)
        val expect59Seconds = "59 seconds ago"
        Assert.assertEquals(
            expectSecond,
            getSecondsElapsedTime(
                resources,
                timeSecond
            )
        )
        Assert.assertEquals(
            expect30Seconds,
            getSecondsElapsedTime(
                resources,
                time30Seconds
            )
        )
        Assert.assertEquals(
            expect59Seconds,
            getSecondsElapsedTime(
                resources,
                time59Seconds
            )
        )
    }

    @Test
    fun elapsed_minutes_test() {
        val timeMinute = 60L
        val expectMinute = "1 minute ago"
        val time15Minutes = 900L
        val expect15Minutes = "15 minutes ago"
        val time59Minutes = 3540L // almost 59 minutes (1 hour)
        val expect59Minutes = "59 minutes ago"
        Assert.assertEquals(
            expectMinute,
            getMinutesElapsedTime(
                resources,
                timeMinute
            )
        )
        Assert.assertEquals(
            expect15Minutes,
            getMinutesElapsedTime(
                resources,
                time15Minutes
            )
        )
        Assert.assertEquals(
            expect59Minutes,
            getMinutesElapsedTime(
                resources,
                time59Minutes
            )
        )
    }

    @Test
    fun elapsed_hours_test() {
        val timeHour = 3600L
        val expectHour = "1 hour ago"
        val time2Hours = 7200L
        val expect2Hours = "2 hours ago"
        val time23Hours = 86399L // almost 24 hours (1 day)
        val expect23Hours = "23 hours ago"
        Assert.assertEquals(
            expectHour,
            getHourlyElapsedTime(
                resources,
                timeHour
            )
        )
        Assert.assertEquals(
            expect2Hours,
            getHourlyElapsedTime(
                resources,
                time2Hours
            )
        )
        Assert.assertEquals(
            expect23Hours,
            getHourlyElapsedTime(
                resources,
                time23Hours
            )
        )
    }

    @Test
    fun elapsed_days_test() {
        val timeDay = 86_400L
        val expectDay = "1 day ago"
        val time6Days = 604_799L // almost 7 days (1 week)
        val expect6Days = "6 days ago"
        Assert.assertEquals(
            expectDay,
            getDailyElapsedTime(
                resources,
                timeDay
            )
        )
        Assert.assertEquals(
            expect6Days,
            getDailyElapsedTime(
                resources,
                time6Days
            )
        )
    }

    @Test
    fun elapsed_weeks_test() {
        val timeWeek = 604_800L
        val expectWeek = "1 week ago"
        val time2Weeks = 1_209_600L
        val expect2Weeks = "2 weeks ago"
        val time3Weeks = 2_419_199L // almost 4 weeks (1 month)
        val expect3Weeks = "3 weeks ago"
        Assert.assertEquals(
            expectWeek,
            getWeeklyElapsedTime(
                resources,
                timeWeek
            )
        )
        Assert.assertEquals(
            expect2Weeks,
            getWeeklyElapsedTime(
                resources,
                time2Weeks
            )
        )
        Assert.assertEquals(
            expect3Weeks,
            getWeeklyElapsedTime(
                resources,
                time3Weeks
            )
        )
    }

    @Test
    fun elapsed_month_test() {
        val timeMonth = 2_629_746L
        val expectMonth = "1 month ago"
        val time2Months = 5_259_492L
        val expect2Months = "2 months ago"
        val time11Months = 31_556_951L // almost 12 months (1 year)
        val expect11Months = "11 months ago"
        Assert.assertEquals(
            expectMonth,
            getMonthlyElapsedTime(
                resources,
                timeMonth
            )
        )
        Assert.assertEquals(
            expect2Months,
            getMonthlyElapsedTime(
                resources,
                time2Months
            )
        )
        Assert.assertEquals(
            expect11Months,
            getMonthlyElapsedTime(
                resources,
                time11Months
            )
        )
    }

    @Test
    fun elapsed_years_test() {
        val timeYear = 31_556_952L
        val expectYear = "1 year ago"
        val time5Years = 157_784_760L
        val expect5Years = "5 years ago"
        Assert.assertEquals(
            expectYear,
            getYearlyElapsedTime(
                resources,
                timeYear
            )
        )
        Assert.assertEquals(
            expect5Years,
            getYearlyElapsedTime(
                resources,
                time5Years
            )
        )
    }

    private fun setEnglishLocale() {
        val locale = Locale("en")
        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context = context.createConfigurationContext(configuration)
    }
}
