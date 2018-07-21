package chapter3

import java.util.*

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Initializing objects the clean way using the run scoping function
 */
fun main(vararg args: String) {
    val calendar = Calendar.Builder().run {
        setCalendarType("iso8601")
        setDate(2018, 1, 18)
        setTimeZone(TimeZone.getTimeZone("GMT-8:00"))
        build()
    }
    print(calendar.time)
}