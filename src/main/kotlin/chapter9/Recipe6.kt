package chapter9

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Chapter: Unit tests with JUnit and Kotlin Mockito
 * Recipe: Working with Kotlin test assertions
 */

class Recipe6 {

    @Test
    fun `sample test`() {
        assertTrue(2 + 2 == 4)
    }
}