package chapter2.recipe4

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Destructuring types
 */
fun main(vararg args: String) {
    val (id, turnedOn) = LightBulb(1)
    print("Light bulb number $id is turned ${if (turnedOn) "on" else "off"}")
}

operator fun LightBulb.component1() = this.id
operator fun LightBulb.component2() = this.turnedOn

