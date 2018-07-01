package chapter9

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Chapter: Unit tests with JUnit and Kotlin Mockito
 * Recipe: Defining custom test rules
 */


class Recipe5 {

    @Test
    fun `sample test`() {
        assertTrue(2 + 2 == 4)
    }
}