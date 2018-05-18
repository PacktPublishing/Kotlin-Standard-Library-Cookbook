package chapter_1

fun main(vararg args: String) {
    ('z' downTo 'a' step 2).forEach { character -> print(character) }
}