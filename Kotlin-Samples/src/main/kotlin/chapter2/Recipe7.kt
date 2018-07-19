package chapter2

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Infix notation for functions
 */
fun main(vararg args: String) {
    print("This" concat "is" concat "weird")
}

infix fun String.concat(next: String): String = this + next
