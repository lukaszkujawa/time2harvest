package net.systemsarchitect.time2harvest.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun daysDiff(to: LocalDate, from: LocalDate) =
        to.toEpochDay() - from.toEpochDay()

fun daysTo(to: LocalDate) =
        daysDiff(to, LocalDate.now())

fun daysToFromString(to: String) =
        daysTo(LocalDate.parse(to, DateTimeFormatter.ISO_DATE))