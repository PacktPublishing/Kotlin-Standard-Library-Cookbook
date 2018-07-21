package chapter4

import java.time.Instant

/**
 * Chapter: Powerful Data Processing
 * Recipe: Composing and consuming collections the easy way
 */
fun main(vararg args: String) {
    val sentMessages = listOf (
            Message("Hi Agat, any plans for the evening?", "Samuel"),
            Message("Great, I'll take some wine too", "Samuel")
    )
    val inboxMessages = mutableListOf(
            Message("Let's go out of town and watch the stars tonight!", "Agat"),
            Message("Excelent!", "Agat")
    )

    val allMessages: List<Message> = sentMessages + inboxMessages

    allMessages.forEach { (text, _) ->
        println(text)
    }

}

val sentMessages = listOf (
        Message("Hi Agat, any plans for the evening?", "Samuel"),
        Message("Great, I'll take some wine too", "Samuel")
)
val inboxMessages = mutableListOf(
        Message("Let's go out of town and watch the stars tonight!", "Agat"),
        Message("Excelent!", "Agat")
)

data class Message(val text: String,
                   val sender: String,
                   val timestamp: Instant = Instant.now())