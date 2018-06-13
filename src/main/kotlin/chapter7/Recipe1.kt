package chapter7

import kotlin.concurrent.thread

/**
 * Chapter: Making Asynchronous programming great again
 * Recipe: Executing tasks in background using threads
 */
fun main(vararg args: String) {
    println("Running on ${getCurrentThreadName()}")

    thread {
        println("Starting async operation on ${getCurrentThreadName()}")
        `5 sec long task`()
        println("Ending async operation on ${getCurrentThreadName()}")
    }

    thread {
        println("Starting async operation on ${getCurrentThreadName()}")
        `2 sec long task`()
        println("Ending async operation on ${getCurrentThreadName()}")
    }
}

private fun `5 sec long task`() {
    Thread.sleep(5000)
}

private fun `2 sec long task`() {
    Thread.sleep(2000)
}

fun getCurrentThreadName(): String = Thread.currentThread().name
