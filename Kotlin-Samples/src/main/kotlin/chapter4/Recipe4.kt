package chapter4

import chapter4.Recipe4.allMessages
import java.time.Instant

/**
 * Chapter: Powerful Data Processing
 * Recipe: Sorting data with custom comparators
 */
fun main(vararg args: String) {
    allMessages.forEach { println(it.text) }
}

object Recipe4 {
    data class Message(val text: String,
                       val sender: String,
                       val receiver: String,
                       val time: Instant = Instant.now())

    val sentMessages = listOf(
            Message("I'm programming in Kotlin, of course",
                    "Samuel",
                    "Agat",
                    Instant.parse("2018-12-18T10:13:35Z")),
            Message("Sure!",
                    "Samuel",
                    "Agat",
                    Instant.parse("2018-12-18T10:15:35Z"))
    )

    val inboxMessages = mutableListOf(
            Message("Hey Sam, any plans for the evening?",
                    "Samuel",
                    "Agat",
                    Instant.parse("2018-12-18T10:12:35Z")),
            Message("That's cool, can I join you?",
                    "Samuel",
                    "Agat",
                    Instant.parse("2018-12-18T10:14:35Z"))
    )

    val allMessages = sentMessages + inboxMessages
}
