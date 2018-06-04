package chapter6

import java.io.File
import java.io.File.separator as SEPARATOR

/**
 * Chapter: Friendly I/O operations
 * Recipe: Ensuring stream closing with the use function
 */
fun main(vararg args: String) {

    val fileName = "src${SEPARATOR}main${SEPARATOR}resources${SEPARATOR}file1.txt"

    val stream1 = File(fileName).inputStream()

    val stream2 = File(fileName).inputStream()

    stream2.use {
        it.readBytes().also { println(String(it)) }
    }

//    stream1.readBytes()
//    stream2.readBytes()

}