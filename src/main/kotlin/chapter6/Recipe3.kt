package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Reading the content of a file line by line
 */
fun main(vararg args: String) {

    val fileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}hello_world.txt"

    val file = File(fileName)

    val fileLines = file.readLines()

    fileLines.forEach { println(it) }
}