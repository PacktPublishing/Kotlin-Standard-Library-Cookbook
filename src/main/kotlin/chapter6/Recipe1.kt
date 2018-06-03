package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Reading the content of a file
 */
fun main(vararg args: String) {

    val filePahtName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}file1.txt"

    val file = File(filePahtName)

    val fileText: String = file.readText()

    println(fileText)

}