package chapter_1

/**
 * Applying sequences to solve algorithmic problems
 */
fun main(vararg args: String) {
    println(fibonacci().take(20).toList())
}

fun fibonacci(): Sequence<Int> {
    return generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
            .map { it.first }
}