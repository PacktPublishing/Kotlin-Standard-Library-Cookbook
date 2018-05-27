package chapter5

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Restricting property's updates with Vetoable delegate
 */

fun main(vararg args: String) {
    val initialTemperature = 1
    val updateCondition = { _: KProperty<*>, oldValue: Int, newValue: Int -> Math.abs(oldValue - newValue) >= 10 }
    var temperature: Int by Delegates.vetoable(initialTemperature, updateCondition)

    temperature = 10
    println("Current temperature: $temperature")

    temperature = 11
    println("Current temperature: $temperature")

    temperature = 12
    println("Current temperature: $temperature")

    temperature = 30
    println("Current temperature: $temperature")

}

