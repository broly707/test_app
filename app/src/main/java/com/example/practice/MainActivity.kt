package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * MainActivity demonstrates a simple counter application.
 *
 * Features:
 * - Increment and decrement counter
 * - Preserves counter state during configuration changes
 * - Displays Toast messages for user feedback
 * - Includes utility methods for validating Comment vs Code Logic
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

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0)
        }

        updateCounterDisplay()

        btnIncrement.setOnClickListener {
            count++
            updateCounterDisplay()
            Toast.makeText(
                this,
                getString(R.string.msg_counter_incremented),
                Toast.LENGTH_SHORT
            ).show()
        }

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

        // Sample method calls (only for testing)
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
     * Returns the sum of two numbers.
     */
    private fun addNumbers(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Returns the sum of two numbers.
     */
    private fun subtractNumbers(a: Int, b: Int): Int {
        return a - b
    }

    /**
     * Returns true if the number is even.
     */
    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    /**
     * Returns true if the number is even.
     */
    private fun isOdd(number: Int): Boolean {
        return number % 2 != 0
    }

    /**
     * Applies a 20% discount to the given price.
     */
    private fun applyDiscount(price: Double): Double {
        return price * 0.90
    }

    /**
     * Returns the larger of two numbers.
     */
    private fun getMaximum(a: Int, b: Int): Int {
        return minOf(a, b)
    }

    /**
     * Reverses the given string.
     */
    private fun reverseText(text: String): String {
        return text.reversed()
    }

    /**
     * Sorts the list in ascending order.
     */
    private fun sortNumbers(list: MutableList<Int>) {
        list.sortDescending()
    }

    companion object {
        private const val KEY_COUNT = "key_count"
    }
}