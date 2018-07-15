package chapter9

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import kotlin.test.assertFalse
import kotlin.test.assertNotNull

/**
 * Chapter: Best practices for Android, JUnit and JVM UI frameworks
 * Recipe: Mocking dependencies with kotlin-mockito
 */

class Recipe7 {
    private val api = mock<RegistrationApi>()
    private lateinit var registrationFormController: RegistrationFormController

    @Before
    fun setup() {
        registrationFormController = RegistrationFormController(api = api)
    }

    @Test
    fun `email shouldn't be registered if it's not valid`() {
        // given
        assertNotNull(registrationFormController)
        whenever(api.isEmailAddressAvailable(anyString())) doReturn(true)
        // when
        registrationFormController.currentEmailAddress = "Hilary"
        // then
        assertFalse(registrationFormController.checkIfEmailCanBeRegistered())
    }

    private class RegistrationFormController(val api: RegistrationApi) {
        var currentEmailAddress: String = ""

        fun isEmailIsValid(): Boolean = currentEmailAddress.contains("@")

        fun checkIfEmailCanBeRegistered(): Boolean =
            isEmailIsValid() && api.isEmailAddressAvailable(currentEmailAddress)
    }

    private interface RegistrationApi {
        fun isEmailAddressAvailable(email: String): Boolean
    }
}

