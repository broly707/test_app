package com.example.practice.utils

/**
 * Helper class to manage counter logic and validation.
 */
class CounterHelper(private var count: Int = 0) {

    fun getCount(): Int = count

    fun increment(): Int {
        count++
        return count
    }

    fun decrement(): Int {
        if (count > 0) {
            count--
        }
        return count
    }

    fun reset(): Int {
        count = 0
        return count
    }

    fun isEven(): Boolean = count % 2 == 0
}
