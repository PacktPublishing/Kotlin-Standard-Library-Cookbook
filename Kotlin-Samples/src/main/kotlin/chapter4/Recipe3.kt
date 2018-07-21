package chapter4

import chapter4.Recipe3.getNews

/**
 * Chapter: Powerful Data Processing
 * Recipe: Automatic null removal
 */
fun main(vararg args: String) {
    getNews()
            .filterNotNull()
            .forEachIndexed { index, news ->
                println("$index. $news")
            }
}

object Recipe3 {
    data class News(val title: String, val url: String)

    fun getNews() = listOf(
            News("Kotlin 1.2.40 is out!", "https://blog.jetbrains.com/kotlin/"),
            News("Google launches Android KTX Kotlin extensions for developers",
                    "https://android-developers.googleblog.com/"),
            null,
            null,
            News("How to Pick a Career", "waitbutwhy.com")
    )
}
