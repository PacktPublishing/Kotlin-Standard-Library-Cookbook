package chapter9

import java.lang.Integer.parseInt
/**
 * Chapter: Miscellaneous
 * Recipe:
 */

fun main(vararg args: String) {
    val input = null
    val result = when(input) {
        is Int -> input
        is String -> parseInt(input)
        else -> 0
    }
    println(result)
}