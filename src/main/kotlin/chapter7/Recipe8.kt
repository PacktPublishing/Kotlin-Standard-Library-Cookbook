package chapter7

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.suspendCoroutine
import kotlin.system.measureTimeMillis

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Wrapping third-party callback-style APIs with coroutines
 */
fun main(vararg args: String) = runBlocking {
    val time = measureTimeMillis {
        val asyncResults = async {
            getResults()
        }

        println("getResults() is running in bacground. Main thread is not blocked.")

        asyncResults.await().map { println(it.displayName) }

        println("getResults() completed")
    }

    println("Total time elapsed: $time ms")
}

suspend fun getResults(): List<Result> =
    suspendCoroutine { continuation: Continuation<List<Result>> ->
        getResultsAsync { continuation.resume(it) }
    }

fun getResultsAsync(callback: (List<Result>) -> Unit) =
    thread {
        val results = mutableListOf<Result>()

        // Simulate some extensive bacground task
        Thread.sleep(1000)

        results.add(Result("a"))
        results.add(Result("b"))
        results.add(Result("c"))

        callback(results)
    }

data class Result(val displayName: String)