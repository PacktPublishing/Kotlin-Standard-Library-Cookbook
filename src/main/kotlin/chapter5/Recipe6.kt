package chapter5

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Advanced observer pattern using ObservableProperty
 */

fun main(vararg args: String) {
    val initialTemperature = 1

    var observableVetoableTemperature by object: ObservableProperty<Int>(initialTemperature) {
        override fun beforeChange(property: KProperty<*>, oldValue: Int, newValue: Int): Boolean {
            return Math.abs(oldValue - newValue) >= 10
        }

        override fun afterChange(property: KProperty<*>, oldValue: Int, newValue: Int) {
            println(newValue)
        }
    }

    observableVetoableTemperature = 11
    observableVetoableTemperature = 12
    observableVetoableTemperature = 13
    observableVetoableTemperature = 14
    observableVetoableTemperature = 30

}

