package chapter4

import chapter4.Recipe6.messages
import java.time.Instant

/**
 * Chapter: Powerful Data Processing
 * Recipe: Dividing data into subsets
 */
fun main(vararg args: String) {
    val pagedMessages = messages.windowed(4, partialWindows = true, step = 4) {
        it.map { it.text }
    }
    pagedMessages.forEach { println(it) }
}

object Recipe6 {
    data class Message(val text: String,
                       val time: Instant = Instant.now())

    val messages = listOf(
            Message("Any plans for the evening?"),
            Message("Learning Kotlin, of course"),
            Message("I'm going to watch the new Star Wars movie"),
            Message("Would u like to join?"),
            Message("Meh, I don't know"),
            Message("See you later!"),
            Message("I like ketchup"),
            Message("Did you send CFP for Kotlin Conf?"),
            Message("Sure!")
    )
}
