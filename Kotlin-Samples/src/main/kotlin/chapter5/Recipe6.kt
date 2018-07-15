package chapter5

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

/**
 * Chapter: Tasteful design patterns adopting Kotlin concepts
 * Recipe: Implementing advanced observer using custom property delegate
 */

fun main(vararg args: String) {
    val initialTemperature = 1
    val updatePrecondition: (Int, Int) -> Boolean =
            { oldValue, newValue -> Math.abs(oldValue - newValue) >= 10 }

    val updateListener: (Int, Int) -> Unit = { _, newValue -> println(newValue) }

    var temperature: Int by ObservableVetoable(initialTemperature,
                                               updatePrecondition,
                                               updateListener)

    temperature = 11
    temperature = 12
    temperature = 13
    temperature = 14
    temperature = 30

}

class ObservableVetoable<T>(initialValue: T,
                            val updatePrecondition: (old: T, new: T) -> Boolean,
                            val updateListener: (old: T, new: T) -> Unit) :
        ObservableProperty<T>(initialValue = initialValue) {

    override fun beforeChange(property: KProperty<*>,
                              oldValue: T,
                              newValue: T): Boolean =
            updatePrecondition(oldValue, newValue)

    override fun afterChange(property: KProperty<*>,
                             oldValue: T,
                             newValue: T) =
            updateListener(oldValue, newValue)
}

