package chapter1

import java.time.LocalDate

/**
 * Chapter: Charm of ranges, progressions and sequences
 * Recipe: Building a custom progression to traverse dates
 */
fun main(vararg args: String) {
    val startDate = LocalDate.of(2020, 1, 1)
    val endDate = LocalDate.of(2020, 12, 31)

    for (date in startDate..endDate step 7) {
        println("${date.dayOfWeek} $date ")
    }
}

class DateIterator(val startDate: LocalDate,
                   val endDateInclusive: LocalDate,
                   val stepDays: Long) : Iterator<LocalDate> {
    private var currentDate = startDate
    override fun hasNext() = currentDate <= endDateInclusive
    override fun next(): LocalDate {
        val next = currentDate
        currentDate = currentDate.plusDays(stepDays)
        return next
    }
}

class DateProgression(override val start: LocalDate,
                      override val endInclusive: LocalDate,
                      val stepDays: Long = 1) :
        Iterable<LocalDate>,
        ClosedRange<LocalDate> {
    override fun iterator(): Iterator<LocalDate> {
        return DateIterator(start, endInclusive, stepDays)
    }

    infix fun step(days: Long) = DateProgression(start, endInclusive, days)
}

operator fun LocalDate.rangeTo(other: LocalDate) = DateProgression(this, other)
