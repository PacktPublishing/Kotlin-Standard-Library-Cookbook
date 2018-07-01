package chapter9

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Chapter: Unit tests with JUnit and Kotlin Mockito
 * Recipe: Mocking dependencies with kotlin-mockito
 */


class Recipe2 {

    @Test
    fun `sample test`() {
        assertTrue(2 + 2 == 4)
    }
}