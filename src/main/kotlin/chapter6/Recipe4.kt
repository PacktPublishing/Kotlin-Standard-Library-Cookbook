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

    if (file.exists()) file.delete()

    file.apply {
        appendText("Yo") // autocloses any streams which are opened during write operation
        appendText("\n")
        appendText("Yo")
        appendText("\n")
        appendBytes("Yo!".toByteArray())
    }

}