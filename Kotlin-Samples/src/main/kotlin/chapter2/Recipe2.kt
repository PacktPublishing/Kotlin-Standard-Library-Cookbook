package chapter2

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Declaring interfaces containing default implementations
 */
fun main(vararg args: String) {
    val form = RegistrationForm()
    form.onInputTextUpdated("Hilary")
}

class RegistrationForm(override var input: String = ""): EmailValidator {
    fun onInputTextUpdated(newText: String) {
        this.input = newText

        if (!isEmailValid()) {
            print("Wait! You've entered wrong email...")
        } else {
            print("Email is correct, thanks: ${getUserLogin()}!")
        }
    }
}

interface EmailValidator {
    var input: String

    fun isEmailValid(): Boolean = input.contains("@")

    fun getUserLogin(): String =
            if (isEmailValid()) {
                input.substringBefore("@")
            } else {
                ""
            }
}