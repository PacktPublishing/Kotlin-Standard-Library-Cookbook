package chapter3

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Discovering basic scoping functions – let, also, apply
 */
fun main(vararg args: String) {
    getPlayers()?.let {
        it.also {
            println("${it.size} players records fetched")
            println(it)
        }.let {
            it.sortedByDescending { it.bestScore }
        }.let {
            it.first()
        }.apply {
            print("Best Player: $name")
        }
    }
}

data class Player(val name: String, val bestScore: Int)

fun getPlayers(): List<Player>? = listOf(
        Player("Stefan Madej", 109),
        Player("Adam Ondra", 323),
        Player("Chris Charma", 239))