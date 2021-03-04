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
class ElapsedTimeRussianTest {

    private lateinit var resources: Resources
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().context
        setRussianLocale()
        resources = context.resources
    }

    @Test
    fun elapsed_seconds_test() {
        val timeSecond = 1L
        val expectSecond = "1 секунду назад"
        val time34Seconds = 34L
        val expect34Seconds = "34 секунды назад"
        val time59Seconds = 59L // almost 60 seconds (1 minute)
        val expect59Seconds = "59 секунд назад"
        Assert.assertEquals(expectSecond, getSecondsElapsedTime(resources, timeSecond))
        Assert.assertEquals(expect34Seconds, getSecondsElapsedTime(resources, time34Seconds))
        Assert.assertEquals(expect59Seconds, getSecondsElapsedTime(resources, time59Seconds))
    }

    @Test
    fun elapsed_minutes_test() {
        val timeMinute = 60L
        val expectMinute = "1 минуту назад"
        val time22Minutes = 1320L
        val expect22Minutes = "22 минуты назад"
        val time59Minutes = 3540L // almost 59 minutes (1 hour)
        val expect59Minutes = "59 минут назад"
        Assert.assertEquals(expectMinute, getMinutesElapsedTime(resources, timeMinute))
        Assert.assertEquals(expect22Minutes, getMinutesElapsedTime(resources, time22Minutes))
        Assert.assertEquals(expect59Minutes, getMinutesElapsedTime(resources, time59Minutes))
    }

    @Test
    fun elapsed_hours_test() {
        val timeHour = 3600L
        val expectHour = "1 час назад"
        val time2Hours = 7200L
        val expect2Hours = "2 часа назад"
        val time18Hours = 64800L
        val expect18Hours = "18 часов назад"
        Assert.assertEquals(expectHour, getHourlyElapsedTime(resources, timeHour))
        Assert.assertEquals(expect2Hours, getHourlyElapsedTime(resources, time2Hours))
        Assert.assertEquals(expect18Hours, getHourlyElapsedTime(resources, time18Hours))
    }

    @Test
    fun elapsed_days_test() {
        val timeDay = 86_400L
        val expectDay = "1 день назад"
        val time2Days = 172_800L
        val expect2Days = "2 дня назад"
        val time6Days = 604_799L // almost 7 days (1 week)
        val expect6Days = "6 дней назад"
        Assert.assertEquals(expectDay, getDailyElapsedTime(resources, timeDay))
        Assert.assertEquals(expect2Days, getDailyElapsedTime(resources, time2Days))
        Assert.assertEquals(expect6Days, getDailyElapsedTime(resources, time6Days))
    }

    @Test
    fun elapsed_weeks_test() {
        val timeWeek = 604_800L
        val expectWeek = "1 неделю назад"
        val time2Weeks = 1_209_600L
        val expect2Weeks = "2 недели назад"
        val time7Weeks = 4_233_600L
        val expect3Weeks = "7 недель назад"
        Assert.assertEquals(expectWeek, getWeeklyElapsedTime(resources, timeWeek))
        Assert.assertEquals(expect2Weeks, getWeeklyElapsedTime(resources, time2Weeks))
        Assert.assertEquals(expect3Weeks, getWeeklyElapsedTime(resources, time7Weeks))
    }

    @Test
    fun elapsed_month_test() {
        val timeMonth = 2_592_000L
        val expectMonth = "1 месяц назад"
        val time2Months = 5_184_000L
        val expect2Months = "2 месяца назад"
        val time11Month = 31_103_999L // almost 12 months (1 year)
        val expect11Month = "11 месяцев назад"
        Assert.assertEquals(expectMonth, getMonthlyElapsedTime(resources, timeMonth))
        Assert.assertEquals(expect2Months, getMonthlyElapsedTime(resources, time2Months))
        Assert.assertEquals(expect11Month, getMonthlyElapsedTime(resources, time11Month))
    }

    @Test
    fun elapsed_years_test() {
        val timeYear = 31_104_000L
        val expectYear = "1 год назад"
        val time2Years = 62_208_000L
        val expect2Years = "2 года назад"
        val time5Years = 155_520_000L
        val expect5Years = "5 лет назад"
        Assert.assertEquals(expectYear, getYearlyElapsedTime(resources, timeYear))
        Assert.assertEquals(expect2Years, getYearlyElapsedTime(resources, time2Years))
        Assert.assertEquals(expect5Years, getYearlyElapsedTime(resources, time5Years))
    }

    private fun setRussianLocale() {
        val locale = Locale("ru")
        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context = context.createConfigurationContext(configuration)
    }
}
