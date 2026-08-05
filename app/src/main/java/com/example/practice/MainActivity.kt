```kotlin
package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * MainActivity hosts a simple counter screen.
 *
 * Responsibilities:
 * - Displays the current counter value.
 * - Allows the user to increment and decrement the counter.
 * - Preserves the counter value during configuration changes.
 * - Displays Toast messages for user actions.
 *
 * Note:
 * This class also contains sample utility methods that are used only
 * for demonstration and testing purposes.
 */
class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvText)

        val btnIncrement = findViewById<MaterialButton>(R.id.btnIncrement)
        val btnDecrement = findViewById<MaterialButton>(R.id.btnDecrement)

        // Restore counter value after configuration change
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0)
        }

        updateCounterDisplay()

        // Increment button
        btnIncrement.setOnClickListener {
            count++
            updateCounterDisplay()

            Toast.makeText(
                this,
                getString(R.string.msg_counter_incremented),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Decrement button
        btnDecrement.setOnClickListener {
            if (count > 0) {
                count--
            }

            updateCounterDisplay()

            Toast.makeText(
                this,
                getString(R.string.msg_counter_decremented),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Sample method calls (for demonstration/testing)
        addNumbers(5, 3)
        subtractNumbers(10, 4)
        isEven(8)
        isOdd(7)
        applyDiscount(100.0)
        getMaximum(12, 20)
        reverseText("ChatGPT")
        sortNumbers(mutableListOf(5, 2, 8, 1))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    /**
     * Updates the counter value displayed on the screen.
     */
    private fun updateCounterDisplay() {
        tvCounter.text = getString(R.string.counter_format, count)
    }

    /**
     * Returns the sum of two integers.
     *
     * @param a First integer.
     * @param b Second integer.
     * @return Sum of the two integers.
     */
    private fun addNumbers(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Returns the difference of two integers.
     *
     * @param a First integer.
     * @param b Second integer.
     * @return Difference of the two integers.
     */
    private fun subtractNumbers(a: Int, b: Int): Int {
        return a - b
    }

    /**
     * Returns true if the given number is even.
     *
     * @param number Number to evaluate.
     * @return True if the number is even; otherwise false.
     */
    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    /**
     * Returns true if the given number is odd.
     *
     * @param number Number to evaluate.
     * @return True if the number is odd; otherwise false.
     */
    private fun isOdd(number: Int): Boolean {
        return number % 2 != 0
    }

    /**
     * Applies a 10% discount to the given price.
     *
     * @param price Original price.
     * @return Price after applying a 10% discount.
     */
    private fun applyDiscount(price: Double): Double {
        return price * 0.90
    }

    /**
     * Returns the larger of two integers.
     *
     * @param a First integer.
     * @param b Second integer.
     * @return The larger of the two integers.
     */
    private fun getMaximum(a: Int, b: Int): Int {
        return maxOf(a, b)
    }

    /**
     * Returns a new string with the characters in reverse order.
     *
     * @param text Input string.
     * @return Reversed string.
     */
    private fun reverseText(text: String): String {
        return text.reversed()
    }

    /**
     * Sorts the provided list in descending order.
     *
     * @param list Mutable list to sort.
     */
    private fun sortNumbers(list: MutableList<Int>) {
        list.sortDescending()
    }

    companion object {
        private const val KEY_COUNT = "key_count"
    }
}
```
