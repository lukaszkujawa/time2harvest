package net.systemsarchitect.time2harvest.utils


import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


@SpringBootTest
@RunWith(SpringRunner::class)
class LocalDateDaysDiffTest {

    @Test
    fun daysDiff() {
        val date1 = LocalDate.parse("2019-01-01", DateTimeFormatter.ISO_DATE)
        val date2 = LocalDate.parse("2019-01-03", DateTimeFormatter.ISO_DATE)
        val date3 = LocalDate.parse("2020-01-03", DateTimeFormatter.ISO_DATE)

        assertEquals(daysDiff(date1, date2), -2L)
        assertEquals(daysDiff(date2, date1), 2L)
        assertEquals(daysDiff(date3, date1), 367L)
    }

    @Test(expected=DateTimeParseException::class)
    fun daysToFromStringException() {
        daysToFromString("123")
    }

}

