package chapter5

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.intellij.lang.annotations.Language

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing delegated class properties
 */
fun main(vararg args: String) {
    val client = Client.fromJson(SAMPLE_CLIENT_JSON)
    println("name: ${client.name}, email: ${client.email}, cards: ${client.creditCards}")
    println(client.toJson())
}

@Language("JSON")
const val SAMPLE_CLIENT_JSON =
        "{\n  \"name\": \"Mark Zuck\",\n  \"email\": \"mark@fb.com\",\n  \"creditCards\": [\n    {\n      \"holderName\": \"Mark Zuckerber\",\n      \"number\": \"123345456789\",\n      \"cvc\": \"123\",\n      \"expiration\": 1527330705017\n    },\n    {\n      \"holderName\": \"Mark Zuckerber\",\n      \"number\": \"987654321\",\n      \"cvc\": \"321\",\n      \"expiration\": 1527330719816\n    }\n  ]\n}"

data class Client(private val data: Map<String, Any>) {
    val name: String by data
    val email: String by data
    val creditCards: List<CreditCard> by data

    /**
     * Utility function for serializing instance of Client class into JSON format
     */
    fun toJson(): String =
            gson.toJson(data)

    companion object {
        private val gson = Gson()

        /**
         * Utility function for instantiating Client class from JSON string
         */
        fun fromJson(json: String): Client {
            val typeOfHashMap = object : TypeToken<Map<String, Any?>>() {}.type
            val data: Map<String, Any> = gson.fromJson(json, typeOfHashMap)
            return Client(data)
        }
    }
}

data class CreditCard(val holderName: String,
                      val number: String,
                      val cvcCode: String,
                      val expiration: Long)

