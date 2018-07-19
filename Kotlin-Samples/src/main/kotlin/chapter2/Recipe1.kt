package chapter2

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Declaring adjustable functions with default parameters
 */
fun main(vararg args: String) {
    val s = calculateDisplacement(acceleration = 9.81f, duration = 1000)
    println("Displacement of an object in freefall for 1000s is $s m")
}

private fun calculateDisplacement(initialSpeed: Float = 0f,
                          acceleration: Float,
                          duration: Long): Double =
        initialSpeed * duration + 0.5 * acceleration * duration * duration