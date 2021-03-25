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
class ElapsedTimeSpanishTest {

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
        val expectSecond = "Hace 1 segundo"
        val time34Seconds = 34L
        val expect34Seconds = "Hace 34 segundos"
        val time59Seconds = 59L // almost 60 seconds (1 minute)
        val expect59Seconds = "Hace 59 segundos"
        Assert.assertEquals(expectSecond, getSecondsElapsedTime(resources, timeSecond))
        Assert.assertEquals(expect34Seconds, getSecondsElapsedTime(resources, time34Seconds))
        Assert.assertEquals(expect59Seconds, getSecondsElapsedTime(resources, time59Seconds))
    }

    @Test
    fun elapsed_minutes_test() {
        val timeMinute = 60L
        val expectMinute = "Hace 1 minuto"
        val time22Minutes = 1320L
        val expect22Minutes = "Hace 22 minutos"
        val time59Minutes = 3540L // almost 59 minutes (1 hour)
        val expect59Minutes = "Hace 59 minutos"
        Assert.assertEquals(expectMinute, getMinutesElapsedTime(resources, timeMinute))
        Assert.assertEquals(expect22Minutes, getMinutesElapsedTime(resources, time22Minutes))
        Assert.assertEquals(expect59Minutes, getMinutesElapsedTime(resources, time59Minutes))
    }

    @Test
    fun elapsed_hours_test() {
        val timeHour = 3600L
        val expectHour = "1 hora antes"
        val time2Hours = 7200L
        val expect2Hours = "Hace 2 horas"
        val time18Hours = 64800L
        val expect18Hours = "Hace 18 horas"
        Assert.assertEquals(expectHour, getHourlyElapsedTime(resources, timeHour))
        Assert.assertEquals(expect2Hours, getHourlyElapsedTime(resources, time2Hours))
        Assert.assertEquals(expect18Hours, getHourlyElapsedTime(resources, time18Hours))
    }

    @Test
    fun elapsed_days_test() {
        val timeDay = 86_400L
        val expectDay = "Hace 1 día"
        val time2Days = 172_800L
        val expect2Days = "Hace 2 días"
        val time6Days = 604_799L // almost 7 days (1 week)
        val expect6Days = "Hace 6 días"
        Assert.assertEquals(expectDay, getDailyElapsedTime(resources, timeDay))
        Assert.assertEquals(expect2Days, getDailyElapsedTime(resources, time2Days))
        Assert.assertEquals(expect6Days, getDailyElapsedTime(resources, time6Days))
    }

    @Test
    fun elapsed_weeks_test() {
        val timeWeek = 604_800L
        val expectWeek = "Hace 1 semana"
        val time2Weeks = 1_209_600L
        val expect2Weeks = "Hace 2 semanas"
        val time7Weeks = 4_233_600L
        val expect3Weeks = "Hace 7 semanas"
        Assert.assertEquals(expectWeek, getWeeklyElapsedTime(resources, timeWeek))
        Assert.assertEquals(expect2Weeks, getWeeklyElapsedTime(resources, time2Weeks))
        Assert.assertEquals(expect3Weeks, getWeeklyElapsedTime(resources, time7Weeks))
    }

    @Test
    fun elapsed_month_test() {
        val timeMonth = 2_629_746L
        val expectMonth = "Hace 1 mes"
        val time2Months = 5_259_492L
        val expect2Months = "Hace 2 meses"
        val time11Months = 31_556_951L // almost 12 months (1 year)
        val expect11Month = "Hace 11 meses"
        Assert.assertEquals(expectMonth, getMonthlyElapsedTime(resources, timeMonth))
        Assert.assertEquals(expect2Months, getMonthlyElapsedTime(resources, time2Months))
        Assert.assertEquals(expect11Month, getMonthlyElapsedTime(resources, time11Months))
    }

    @Test
    fun elapsed_years_test() {
        val timeYear = 31_556_952L
        val expectYear = "Hace 1 año"
        val time2Years = 63_113_904L
        val expect2Years = "Hace 2 años"
        val time5Years = 157_784_760L
        val expect5Years = "Hace 5 años"
        Assert.assertEquals(expectYear, getYearlyElapsedTime(resources, timeYear))
        Assert.assertEquals(expect2Years, getYearlyElapsedTime(resources, time2Years))
        Assert.assertEquals(expect5Years, getYearlyElapsedTime(resources, time5Years))
    }

    private fun setGermanLocale() {
        val locale = Locale("es")
        Locale.setDefault(locale)
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        context = context.createConfigurationContext(configuration)
    }
}

