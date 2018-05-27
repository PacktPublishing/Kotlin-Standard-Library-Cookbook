package chapter5

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Tracking state with Observer pattern
 */

fun main(vararg args: String) {
    val initialTemperature = 1
    val changesListener = { _: KProperty<*>, _: Int, newValue: Int -> println("Current temperature: $newValue") }
    var temperature: Int by Delegates.observable(initialTemperature, changesListener)

    temperature = 10
    temperature = 11
    temperature = 12
    temperature = 30
}

