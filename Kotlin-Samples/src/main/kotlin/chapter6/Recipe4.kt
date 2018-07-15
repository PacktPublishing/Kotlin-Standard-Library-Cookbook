package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Writing the content to a file
 */
fun main(vararg args: String) {

    val fileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}temp_file"

    val file = File(fileName)

    file.apply {
        val text =
                "\"No one in the brief history of computing " +
                        "has ever written a piece of perfect software. " +
                        "It's unlikely that you'll be the first.\" \nAndy Hunt"
        writeText(text)
    }

    file.readText().apply { println(this) }

}