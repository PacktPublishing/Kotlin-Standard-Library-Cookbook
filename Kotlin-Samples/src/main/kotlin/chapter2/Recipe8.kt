package chapter2

import com.google.gson.Gson

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Smart types checking with generic reified parameters
 */
fun main(vararg args: String) {
    val jsonString = ""
    val response = Gson().fromJson<ApiResponse>(jsonString)
}
data class ApiResponse(val gifsWithPandas: List<ByteArray>)


inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}