package chapter4

import chapter4.Recipe5.Address
import chapter4.Recipe5.generateRecipientsString

/**
 * Chapter: Powerful Data Processing
 * Recipe: Building strings based on dataset elements
 */
fun main(vararg args: String) {
    val addresses = listOf(Address("hilary@gmail.com", "hilly"),
            Address("bob@gmail.com", "bobby"))

    val text = generateRecipientsString(addresses)
    println(text)
}

object Recipe5 {
    fun generateRecipientsString(recipients: List<Address?>): String =
            recipients.filterNotNull()
                    .map { it.emailAddress }
                    .joinToString(", ", "To: ", "<br/>")

    data class Address(val emailAddress: String, val displayName: String)
}
