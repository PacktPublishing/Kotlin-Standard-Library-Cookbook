package chapter7

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Applying coroutines for asynchronous data processing
 */
fun main(vararg args: String) = runBlocking {
    val totalTime = measureTimeMillis {
        (0..10).mapConcurrent {
            delay(1000)
            it * it
        }.map { println(it) }
    }

    println("Total time: $totalTime ms")
}

suspend fun <T, R> Iterable<T>.mapConcurrent(transform: suspend (T) -> R) =
    this.map {
        async { transform(it) }
    }.map {
        it.await()
    }