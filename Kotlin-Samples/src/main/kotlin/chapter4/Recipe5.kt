package chapter4

import chapter4.Recipe5.Address

/**
 * Chapter: Powerful Data Processing
 * Recipe:
 */
fun main(vararg args: String) {
    fun generateRecipientsString(recipients: List<Address?>): String =
            recipients.filterNotNull()
                    .map { it.emailAddress }
                    .joinToString(", ", "To: ", "<br/>")
}

object Recipe5 {
    fun generateRecipientsString(recipients: List<Address?>): String =
            recipients.filterNotNull()
                    .map { it.emailAddress }
                    .joinToString(", ", "To: ", "<br/>")

    data class Address(val emailAddress: String, val displayName: String)
}
