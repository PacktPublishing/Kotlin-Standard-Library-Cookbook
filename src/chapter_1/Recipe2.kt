package chapter_1

/**
 * Chapter: Charm of ranges, progressions and sequences
 * Recipe: Traversing through ranges using progression with a custom step value
 */
fun main(vararg args: String) {
    ('z' downTo 'a' step 2).forEach { character -> print(character) }
}