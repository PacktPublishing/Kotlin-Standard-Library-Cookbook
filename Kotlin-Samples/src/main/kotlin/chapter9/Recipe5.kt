package chapter9

import java.lang.StringBuilder as builder

/**
 * Chapter: Miscellaneous
 * Recipe:
 */

fun main(vararg args: String) {
    val text = builder()
            .append("Code is like humor.")
            .append("When you have to explain it,")
            .append("it’s bad.")
            .toString()
    println(text)
}