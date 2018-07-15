package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Appending a file
 */
fun main(vararg args: String) {

    val fileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}temp_file"

    val file = File(fileName)

    if (file.exists()) file.delete()

    file.apply {
        appendText("\"A language that doesn’t affect the way you think ")
        appendText("about programming ")
        appendText("is worth knowing.\"")
        appendText("\n")
        appendBytes("Alan Perlis".toByteArray())
    }

    file.readText().let { println(it) }

}