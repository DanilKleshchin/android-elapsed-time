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

@RunWith(AndroidJUnit4::class)
class ElapsedTimeGermanTest {

    private lateinit var resources: Resources
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().context
        setGermanLocale()
        resources = context.resources
    }

    @Test
    fun elapsed_seconds_test() {
        val timeSecond = 1L
        val expectSecond = "Vor 1 Sekunde"
        val time34Seconds = 34L
        val expect34Seconds = "Vor 34 Sekunden"
        val time59Seconds = 59L // almost 60 seconds (1 minute)
        val expect59Seconds = "Vor 59 Sekunden"
        Assert.assertEquals(expectSecond, getSecondsElapsedTime(resources, timeSecond))
        Assert.assertEquals(expect34Seconds, getSecondsElapsedTime(resources, time34Seconds))
        Assert.assertEquals(expect59Seconds, getSecondsElapsedTime(resources, time59Seconds))
    }

    @Test
    fun elapsed_minutes_test() {
        val timeMinute = 60L
        val expectMinute = "Vor 1 Minute"
        val time22Minutes = 1320L
        val expect22Minutes = "Vor 22 Minuten"
        val time59Minutes = 3540L // almost 59 minutes (1 hour)
        val expect59Minutes = "Vor 59 Minuten"
        Assert.assertEquals(expectMinute, getMinutesElapsedTime(resources, timeMinute))
        Assert.assertEquals(expect22Minutes, getMinutesElapsedTime(resources, time22Minutes))
        Assert.assertEquals(expect59Minutes, getMinutesElapsedTime(resources, time59Minutes))
    }

    @Test
    fun elapsed_hours_test() {
        val timeHour = 3600L
        val expectHour = "Vor 1 Stunde"
        val time2Hours = 7200L
        val expect2Hours = "Vor 2 Stunden"
        val time18Hours = 64800L
        val expect18Hours = "Vor 18 Stunden"
        Assert.assertEquals(expectHour, getHourlyElapsedTime(resources, timeHour))
        Assert.assertEquals(expect2Hours, getHourlyElapsedTime(resources, time2Hours))
        Assert.assertEquals(expect18Hours, getHourlyElapsedTime(resources, time18Hours))
    }

    @Test
    fun elapsed_days_test() {
        val timeDay = 86_400L
        val expectDay = "Vor 1 Tag"
        val time2Days = 172_800L
        val expect2Days = "Vor 2 Tagen"
        val time6Days = 604_799L // almost 7 days (1 week)
        val expect6Days = "Vor 6 Tagen"
        Assert.assertEquals(expectDay, getDailyElapsedTime(resources, timeDay))
        Assert.assertEquals(expect2Days, getDailyElapsedTime(resources, time2Days))
        Assert.assertEquals(expect6Days, getDailyElapsedTime(resources, time6Days))
    }

    @Test
    fun elapsed_weeks_test() {
        val timeWeek = 604_800L
        val expectWeek = "Vor 1 Woche"
        val time2Weeks = 1_209_600L
        val expect2Weeks = "Vor 2 Wochen"
        val time7Weeks = 4_233_600L
        val expect3Weeks = "Vor 7 Wochen"
        Assert.assertEquals(expectWeek, getWeeklyElapsedTime(resources, timeWeek))
        Assert.assertEquals(expect2Weeks, getWeeklyElapsedTime(resources, time2Weeks))
        Assert.assertEquals(expect3Weeks, getWeeklyElapsedTime(resources, time7Weeks))
    }

    @Test
    fun elapsed_month_test() {
        val timeMonth = 2_629_746L
        val expectMonth = "Vor 1 Monat"
        val time2Months = 5_259_492L
        val expect2Months = "Vor 2 Monaten"
        val time11Months = 31_556_951L // almost 12 months (1 year)
        val expect11Month = "Vor 11 Monaten"
        Assert.assertEquals(expectMonth, getMonthlyElapsedTime(resources, timeMonth))
        Assert.assertEquals(expect2Months, getMonthlyElapsedTime(resources, time2Months))
        Assert.assertEquals(expect11Month, getMonthlyElapsedTime(resources, time11Months))
    }

    @Test
    fun elapsed_years_test() {
        val timeYear = 31_556_952L
        val expectYear = "Vor 1 Jahr"
        val time2Years = 63_113_904L
        val expect2Years = "Vor 2 Jahren"
        val time5Years = 157_784_760L
        val expect5Years = "Vor 5 Jahren"
        Assert.assertEquals(expectYear, getYearlyElapsedTime(resources, timeYear))
        Assert.assertEquals(expect2Years, getYearlyElapsedTime(resources, time2Years))
        Assert.assertEquals(expect5Years, getYearlyElapsedTime(resources, time5Years))
    }

    private fun setGermanLocale() {
        val locale = Locale("de")
        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context = context.createConfigurationContext(configuration)
    }
}
