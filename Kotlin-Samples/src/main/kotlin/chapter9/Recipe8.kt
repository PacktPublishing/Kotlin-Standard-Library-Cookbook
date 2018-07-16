package chapter9

import java.util.*


/**
 * Chapter: Miscellaneous
 * Recipe:
 */

fun main(vararg args: String) {

    println(getRandomNumber() as? Int)
    println(getRandomNumber() as? Double)
    println(getRandomNumber() as? String)
}

private fun getRandomNumber(): Number = Random().nextDouble() * 10