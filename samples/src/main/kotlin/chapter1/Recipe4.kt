package chapter1

import java.util.*

/**
 * Chapter: Charm of ranges, progressions and sequences
 * Recipe: Using range expressions with flow control statements
 */
fun main(vararg args: String) {
    val randomInt = Random().nextInt()

    if (randomInt in 0..10) {
        print("$randomInt belongs to <0, 10> range")
    } else {
        print("$randomInt doesn't belong to <0, 10> range")
    }
}