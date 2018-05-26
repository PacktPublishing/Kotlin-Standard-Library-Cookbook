package chapter5

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.intellij.lang.annotations.Language

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing delegated class properties
 */
fun main(vararg args: String) {
    println("client1:")
    val client1 = Client.fromJson(SAMPLE_CLIENT_JSON)
    println("name: ${client1.name}, email: ${client1.email}, cards: ${client1.creditCards}")
    println(client1.toJson())

    println("client2:")
    val client2 = Client(SAMPLE_CLIENT_MAP)
    println("name: ${client2.name}, email: ${client2.email}, cards: ${client2.creditCards}")
    println(client2.toJson())
}

@Language("JSON")
const val SAMPLE_CLIENT_JSON =
        "{\n  \"name\": \"Mark Zuck\",\n  \"email\": \"mark@fb.com\",\n  \"creditCards\": [\n    {\n      \"holderName\": \"Mark Zuckerber\",\n      \"number\": \"123345456789\",\n      \"cvc\": \"123\",\n      \"expiration\": 1527330705017\n    },\n    {\n      \"holderName\": \"Mark Zuckerber\",\n      \"number\": \"987654321\",\n      \"cvc\": \"321\",\n      \"expiration\": 1527330719816\n    }\n  ]\n}"

val SAMPLE_CLIENT_MAP =
        mapOf("name" to "Mark Zuck", "email" to "mark@fb.com",
                "creditCards" to listOf(
                        CreditCard("Mark Zuckerberg", "123345456789", "123", 1527330705017),
                        CreditCard("Mark Zuckerberg", "987654321", "321", 1527330719816)))

data class Client(private val data: Map<String, Any>) {
    val name: String by data
    val email: String by data
    val creditCards: List<CreditCard> by data

    /**
     * Function for serializing instance of Client class into JSON format
     */
    fun toJson(): String = gson.toJson(data)

    companion object {
        private val gson = Gson()

        /**
         * Utility function for instantiating Client class from JSON string
         */
        fun fromJson(json: String): Client {
            val mapType = object : TypeToken<Map<String, Any>>() {}.type
            val data: Map<String, Any> = gson.fromJson(json, mapType)
            return Client(data)
        }
    }
}

data class CreditCard(val holderName: String,
                      val number: String,
                      val cvcCode: String,
                      val expiration: Long)