package chapter7

import kotlinx.coroutines.experimental.*
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Using coroutines to execute asynchronous concurrent tasks
 */
fun main(vararg args: String) {

    `print current thread name`()

    var sushiCookingJob: Job

    val time = measureTimeMillis {

        sushiCookingJob = launch(CommonPool) {

            val riceCookingJob = launch {
                `cook rice`()
            }

            println("Current thread is not blocked while rice is being cooked")

            `prepare fish`()

            `cut vegetables`()

            riceCookingJob.join()

            `roll the sushi`()
        }

        runBlocking {
            sushiCookingJob.join()
        }
    }

    println("Total time: $time ms")
}

private suspend fun `cook rice`() {
    println("Starting to cook rice")
    delay(10, TimeUnit.SECONDS)
    println("Rice cooked")
}

private suspend fun `prepare fish`() {
    println("Starting to prepare fish")
    delay(2, TimeUnit.SECONDS)
    println("Fish prepared")
}

private suspend fun `cut vegetables`() {
    println("Starting to cut vegetables")
    delay(2, TimeUnit.SECONDS)
    println("Vegetables ready")
}

private suspend fun `roll the sushi`() {
    println("Starting to roll the sushi")
    delay(2, TimeUnit.SECONDS)
    println("Sushi rolled")
}

private fun `print current thread name`() {
    println("Running on ${getCurrentThreadName()}")
    println()
}

private fun getCurrentThreadName(): String = Thread.currentThread().name