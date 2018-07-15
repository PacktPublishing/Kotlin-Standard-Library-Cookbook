package chapter7

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Using coroutines to execute asynchronous tasks and with results handling
 */
fun main(vararg args: String) {

    `print current thread name`()

    launch {
        println("Starting progressbar animation on ${getCurrentThreadName()}")
        `show progress animation`()
    }

    val future = async {
        println("Starting computations on ${getCurrentThreadName()}")
        `calculate the answer to life the universe and everything`()
    }

    println("${getCurrentThreadName()} thread is not blocked while tasks are in progress")

    runBlocking {
        println("\nThe answer to life the universe and everything: ${future.await()}")
        `print current thread name`()
    }
}

private suspend fun `calculate the answer to life the universe and everything`(): Int {
    delay(5000)
    return 42
}

private suspend fun `show progress animation`() {
    val progressBarLength = 30
    var currentPosition = 0
    while (true) {
        print("\r")
        val progressbar = (0 until progressBarLength)
                .map { if (it == currentPosition) " " else "░" }
                .joinToString("")
        print(progressbar)

        delay(50)

        if (currentPosition == progressBarLength) {
            currentPosition = 0
        }
        currentPosition++
    }
}

private fun `print current thread name`() {
    println("Running on ${getCurrentThreadName()}")
}

private fun getCurrentThreadName(): String = Thread.currentThread().name