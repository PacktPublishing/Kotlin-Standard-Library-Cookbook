package chapter4

import java.time.Instant
import chapter4.Recipe2.getMessages
import chapter4.Recipe2.Folder

/**
 * Chapter: Powerful Data Processing
 * Recipe: Filtering datasets
 */
fun main(vararg args: String) {
    getMessages().filter { it.folder == Folder.INBOX && it.sender == "Agat" }
            .forEach { (text) ->
                println(text)
            }
}

object Recipe2 {
    data class Message(val text: String,
                               val sender: String,
                               val receiver: String,
                               val folder: Folder = Folder.INBOX,
                               val timestamp: Instant = Instant.now())

    enum class Folder { INBOX, SENT }

    fun getMessages() = mutableListOf(
            Message("Je t'aime", "Agat", "Sam", Folder.INBOX),
            Message("Hey, Let's go climbing tomorrow", "Stefan", "Sam", Folder.INBOX),
            Message("<3", "Sam", "Agat", Folder.SENT),
            Message("Yeah!", "Sam", "Stefan", Folder.SENT)
    )
}
