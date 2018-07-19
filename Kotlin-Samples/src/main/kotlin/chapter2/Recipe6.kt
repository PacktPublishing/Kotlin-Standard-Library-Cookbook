package chapter2

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Inlining parameters of closure type
 */
fun main(vararg args: String) {
    performHavingLock(ReentrantLock()) {
        print("Wait for it!")
    }
}

fun performHavingLock(lock: Lock, task: () -> Unit) {
    lock.lock()
    try {
        task()
    }
    finally {
        lock.unlock()
    }
}