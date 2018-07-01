package chapter9

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Chapter: Unit tests with JUnit and Kotlin Mockito
 * Recipe: The basics of writing unit tests cases
 */

class Recipe1 {

    @Test
    fun `sample test`() {
        assertTrue(2 + 2 == 4)
    }
}