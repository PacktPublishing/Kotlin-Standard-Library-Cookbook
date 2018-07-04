package chapter9

import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.test.TestCoroutineContext
import kotlinx.coroutines.experimental.withContext
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Chapter: Best practices for Android, JUnit and JVM UI frameworks
 * Recipe: Unit tests for Kotlin coroutines
 */

class Recipe4 {

    @Test
    fun `sample test`() {

        runBlocking {
            val context = TestCoroutineContext()
            withContext(context) {
                context.advanceTimeBy(1, TimeUnit.SECONDS)
            }
        }

    }
}