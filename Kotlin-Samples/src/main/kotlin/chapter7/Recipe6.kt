package chapter7

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Easy coroutine cancelling
 */
fun main(vararg args: String) = runBlocking {
    val job = launch {`show progress animation`()}
    delay(5000)
    job.cancel()
    job.join()
    println("\nJob cancelled and completed")
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