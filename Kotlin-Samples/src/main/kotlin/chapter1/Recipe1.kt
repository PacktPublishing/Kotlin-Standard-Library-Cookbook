package chapter1

/**
 * Chapter: Charm of ranges, progressions and sequences
 * Recipe: Exploring the concept of range expressions to iterate through alphabet characters
 */
fun main(vararg args: String) {
    for(letter in 'Z' downTo 'A') print(letter)
}