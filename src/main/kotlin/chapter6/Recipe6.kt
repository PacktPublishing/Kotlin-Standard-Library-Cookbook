package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Easy files copying
 */
fun main(vararg args: String) {

    val sourceFileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}hello_world.txt"
    val sourceFile = File(sourceFileName)

    val targetFileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}hello_world_copy.txt"
    val targetFile = File(targetFileName)

    if (targetFile.exists()) targetFile.delete()

    sourceFile.copyTo(targetFile)
}