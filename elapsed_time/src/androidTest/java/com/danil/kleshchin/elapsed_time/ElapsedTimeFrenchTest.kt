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
import java.util.*

@RunWith(AndroidJUnit4::class)
class ElapsedTimeFrenchTest {

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
        val expectSecond = "Il y a 1 seconde"
        val time34Seconds = 34L
        val expect34Seconds = "Il y a 34 secondes"
        val time59Seconds = 59L // almost 60 seconds (1 minute)
        val expect59Seconds = "Il y a 59 secondes"
        Assert.assertEquals(expectSecond, getSecondsElapsedTime(resources, timeSecond))
        Assert.assertEquals(expect34Seconds, getSecondsElapsedTime(resources, time34Seconds))
        Assert.assertEquals(expect59Seconds, getSecondsElapsedTime(resources, time59Seconds))
    }

    @Test
    fun elapsed_minutes_test() {
        val timeMinute = 60L
        val expectMinute = "Il y a 1 minute"
        val time22Minutes = 1320L
        val expect22Minutes = "Il y a 22 minutes"
        val time59Minutes = 3540L // almost 59 minutes (1 hour)
        val expect59Minutes = "Il y a 59 minutes"
        Assert.assertEquals(expectMinute, getMinutesElapsedTime(resources, timeMinute))
        Assert.assertEquals(expect22Minutes, getMinutesElapsedTime(resources, time22Minutes))
        Assert.assertEquals(expect59Minutes, getMinutesElapsedTime(resources, time59Minutes))
    }

    @Test
    fun elapsed_hours_test() {
        val timeHour = 3600L
        val expectHour = "Il ya 1 heure"
        val time2Hours = 7200L
        val expect2Hours = "Il y a 2 heures"
        val time18Hours = 64800L
        val expect18Hours = "Il y a 18 heures"
        Assert.assertEquals(expectHour, getHourlyElapsedTime(resources, timeHour))
        Assert.assertEquals(expect2Hours, getHourlyElapsedTime(resources, time2Hours))
        Assert.assertEquals(expect18Hours, getHourlyElapsedTime(resources, time18Hours))
    }

    @Test
    fun elapsed_days_test() {
        val timeDay = 86_400L
        val expectDay = "Il y a 1 jour"
        val time2Days = 172_800L
        val expect2Days = "Il y a 2 jours"
        val time6Days = 604_799L // almost 7 days (1 week)
        val expect6Days = "Il y a 6 jours"
        Assert.assertEquals(expectDay, getDailyElapsedTime(resources, timeDay))
        Assert.assertEquals(expect2Days, getDailyElapsedTime(resources, time2Days))
        Assert.assertEquals(expect6Days, getDailyElapsedTime(resources, time6Days))
    }

    @Test
    fun elapsed_weeks_test() {
        val timeWeek = 604_800L
        val expectWeek = "Il ya 1 semaine"
        val time2Weeks = 1_209_600L
        val expect2Weeks = "Il y a 2 semaines"
        val time7Weeks = 4_233_600L
        val expect3Weeks = "Il y a 7 semaines"
        Assert.assertEquals(expectWeek, getWeeklyElapsedTime(resources, timeWeek))
        Assert.assertEquals(expect2Weeks, getWeeklyElapsedTime(resources, time2Weeks))
        Assert.assertEquals(expect3Weeks, getWeeklyElapsedTime(resources, time7Weeks))
    }

    @Test
    fun elapsed_month_test() {
        val timeMonth = 2_629_746L
        val expectMonth = "Il ya 1 mois"
        val time2Months = 5_259_492L
        val expect2Months = "Il y a 2 mois"
        val time11Months = 31_556_951L // almost 12 months (1 year)
        val expect11Month = "Il y a 11 mois"
        Assert.assertEquals(expectMonth, getMonthlyElapsedTime(resources, timeMonth))
        Assert.assertEquals(expect2Months, getMonthlyElapsedTime(resources, time2Months))
        Assert.assertEquals(expect11Month, getMonthlyElapsedTime(resources, time11Months))
    }

    @Test
    fun elapsed_years_test() {
        val timeYear = 31_556_952L
        val expectYear = "Il y a 1 an"
        val time2Years = 63_113_904L
        val expect2Years = "Il y a 2 ans"
        val time5Years = 157_784_760L
        val expect5Years = "Il y a 5 ans"
        Assert.assertEquals(expectYear, getYearlyElapsedTime(resources, timeYear))
        Assert.assertEquals(expect2Years, getYearlyElapsedTime(resources, time2Years))
        Assert.assertEquals(expect5Years, getYearlyElapsedTime(resources, time5Years))
    }

    private fun setGermanLocale() {
        val locale = Locale("fr")
        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context = context.createConfigurationContext(configuration)
    }
}
