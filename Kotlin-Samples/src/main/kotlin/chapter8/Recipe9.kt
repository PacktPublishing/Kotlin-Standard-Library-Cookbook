package chapter9

import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.test.TestCoroutineContext
import org.junit.Test
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Chapter: Best practices for Android, JUnit and JVM UI frameworks
 * Recipe: Unit tests for Kotlin coroutines
 */

class Recipe4 {

    val api: Api = mock()
    val authenticator = Authenticator(api)

    @Test
    fun `should retry authorisation at least 10 times when Api returns empty token`() {
        whenever(api.authorise(any())) doReturn ""

        val context = TestCoroutineContext()

        runBlocking(context) {
            authenticator.tryToAuthorise("admin:1234".toByteArray(), context).await()
            context.advanceTimeBy(100, TimeUnit.SECONDS)
            verify(api, atLeast(10)).authorise(any())
        }
    }
}

class Authenticator(val api: Api) {

    fun tryToAuthorise(encodedUserNameAndPassword: ByteArray, context: CoroutineContext): Deferred<String> =
            async(context) {
                var authToken = api.authorise(encodedUserNameAndPassword)

                var retryCount = 0
                while (authToken.isEmpty() && retryCount <= 10) {
                    delay(10, TimeUnit.SECONDS)
                    authToken = api.authorise(encodedUserNameAndPassword)
                    retryCount++
                }

                authToken
            }
}

interface Api {
    // returns a non-empty auth token when the given credentials were authorised
    fun authorise(encodedUserNameAndPassword: ByteArray): String
}