package chapter_1

/**
 * Exploring the concept of range expressions to iterate through alphabet characters
 */
fun main(vararg args: String) {
    for(letter in 'Z' downTo 'A') print(letter)
}