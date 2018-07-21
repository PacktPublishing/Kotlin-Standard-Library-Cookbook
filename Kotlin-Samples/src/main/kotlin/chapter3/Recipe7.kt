package chapter3

import java.util.concurrent.ConcurrentHashMap
import kotlin.system.measureNanoTime

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Approach to automatic functions memoization
 */
fun main(vararg args: String) {
    fun factorial(n: Int): Long = if (n == 1) n.toLong() else n * factorial(n - 1)
    val cachedFactorial = ::factorial.memoized()
    println(" Execution time: " + measureNanoTime { cachedFactorial(12) } + " ns")
    println(" Execution time: " + measureNanoTime { cachedFactorial(13) } + " ns")
}

fun <P, R> ((P) -> R).memoized(): (P) -> R = Memoizer.memoize<P, R>(this)

class Memoizer<P, R> private constructor() {

    private val map = ConcurrentHashMap<P, R>()

    private fun doMemoize(function: (P) -> R):  (P) -> R = { param: P ->
        map.computeIfAbsent(param) { param: P ->
            function(param)
        }
    }

    companion object {
        fun <T, U> memoize(function: (T) -> U): (T) -> U =
                Memoizer<T, U>().doMemoize(function)
    }
}