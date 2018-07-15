package chapter7

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newSingleThreadContext
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Using coroutines for asynchronous concurrent tasks execution
 */
fun main(vararg args: String) {

    `print current thread name`()

    var sushiCookingJob: Job

    val time = measureTimeMillis {
        sushiCookingJob = launch(newSingleThreadContext("SushiThread")) {
            `print current thread name`()

            val riceCookingJob = launch {
                `cook rice`()
            }

            println("Current thread is not blocked while rice is being cooked")

            `prepare fish`()

            `cut vegetable`()

            riceCookingJob.join()

            `roll the sushi`()
        }

        runBlocking {
            sushiCookingJob.join()
        }
    }

    println("Total time: $time ms")
}

private fun `cook rice`() {
    println("Starting to cook rice on ${getCurrentThreadName()}")
    Thread.sleep(10000)
    println("Rice cooked")
}

private fun `prepare fish`() {
    println("Starting to prepare fish on ${getCurrentThreadName()}")
    Thread.sleep(2000)
    println("Fish prepared")
}

private fun `cut vegetable`() {
    println("Starting to cut vegetables on ${getCurrentThreadName()}")
    Thread.sleep(2000)
    println("Vegetables ready")
}

private fun `roll the sushi`() {
    println("Starting to roll the sushi on ${getCurrentThreadName()}")
    Thread.sleep(2000)
    println("Sushi rolled")
}

private fun `print current thread name`() {
    println("Running on ${getCurrentThreadName()}")
}

private fun getCurrentThreadName(): String = Thread.currentThread().name