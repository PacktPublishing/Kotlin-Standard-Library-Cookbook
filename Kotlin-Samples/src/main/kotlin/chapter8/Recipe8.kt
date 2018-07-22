package chapter9

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.anyString
import kotlin.properties.Delegates
import kotlin.reflect.KProperty
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Chapter: Best practices for Android, JUnit and JVM UI frameworks
 * Recipe: Verifying function invocations
 */

class Recipe8 {
    private val api = mock<RegistrationApi>()
    private val view = mock<TextView>()
    private var registrationForm = RegistrationForm(api, view)

    @Test
    fun `should display success message when email address is available`() {
        // given
        assertNotNull(registrationForm)
        // when we update the currentEmailAddress to any String
        whenever(api.isEmailAddressAvailable(ArgumentMatchers.anyString())) doReturn(true)
        registrationForm.currentEmailAddress = "hilary@gmail.com"
        // then
        assertTrue(registrationForm.checkIfEmailCanBeRegistered())
        verify(view).showSuccessMessage("Email address is available!")
    }

    @Test
    fun `should display error message when email address isn't available`() {
        // given
        assertNotNull(registrationForm)
        // when
        registrationForm.currentEmailAddress = "hilary@gmail.com"
        whenever(api.isEmailAddressAvailable(ArgumentMatchers.anyString())) doReturn(false)
        // then
        assertTrue(registrationForm.isEmailIsValid())
        verify(view).showErrorMessage(anyString())
    }

    private class RegistrationForm(val api: RegistrationApi, val view: TextView) {
        var currentEmailAddress: String by Delegates.observable("", ::onEmailAddressNewValue)

        fun onEmailAddressNewValue(prop: KProperty<*>, old: String, new: String) {
            if (checkIfEmailCanBeRegistered()) {
                view.showSuccessMessage("Email address is available!")
            } else {
                view.showErrorMessage("This email address is not available.")
            }
        }

        fun checkIfEmailCanBeRegistered(): Boolean =
                isEmailIsValid() && api.isEmailAddressAvailable(currentEmailAddress)

        fun isEmailIsValid(): Boolean = currentEmailAddress.contains("@")

    }

    private interface RegistrationApi {
        fun isEmailAddressAvailable(email: String): Boolean
    }

    private interface TextView {
        fun showSuccessMessage(message: String)
        fun showErrorMessage(message: String)
    }
}