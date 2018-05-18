package chapter_1

/**
 * Traversing through ranges using progression with a custom step value
 */
fun main(vararg args: String) {
    ('z' downTo 'a' step 2).forEach { character -> print(character) }
}