package chapter2

import com.google.gson.Gson

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Overloading operators
 */
fun main(vararg args: String) {
    val position1 = Position(132.5f, 4f, 3.43f)
    val position2 = position1 - Position(1.5f, 400f, 11.56f)
    println(position2)
}

data class Position(val x: Float, val y: Float, val z: Float) {
    operator fun plus(other: Position) =
            Position(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Position) =
            Position(x - other.x, y - other.y, z - other.z)
}