package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * MainActivity hosts a simple temperature converter.
 *
 * Responsibilities:
 * - Increases and decreases the Celsius value.
 * - Converts Celsius to Fahrenheit.
 * - Displays conversion results.
 * - Preserves the temperature across configuration changes.
 *
 * Note:
 * This class also contains helper methods used for demonstration
 * and testing purposes.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var tvTemperature: TextView
    private var celsius = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTemperature = findViewById(R.id.tvText)

        val btnIncrease = findViewById<MaterialButton>(R.id.btnIncrement)
        val btnDecrease = findViewById<MaterialButton>(R.id.btnDecrement)

        if (savedInstanceState != null) {
            celsius = savedInstanceState.getInt(KEY_TEMP, 25)
        }

        updateTemperature()

        btnIncrease.setOnClickListener {
            celsius++
            updateTemperature()

            Toast.makeText(
                this,
                "Temperature Increased",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnDecrease.setOnClickListener {
            celsius--
            updateTemperature()

            Toast.makeText(
                this,
                "Temperature Decreased",
                Toast.LENGTH_SHORT
            ).show()
        }

        convertToFahrenheit(celsius)
        isFreezing(celsius)
        averageTemperature(listOf(20, 22, 24, 26))
        highestTemperature(listOf(15, 20, 30, 28))
        lowestTemperature(listOf(15, 20, 30, 28))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_TEMP, celsius)
    }

    /**
     * Updates the current temperature displayed on screen.
     */
    private fun updateTemperature() {
        tvTemperature.text = "Temperature: $celsius°C"
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius Temperature in Celsius.
     * @return Temperature in Fahrenheit.
     */
    private fun convertToFahrenheit(celsius: Int): Double {
        return (celsius * 9 / 5.0) + 32
    }

    /**
     * Determines whether the temperature is at or below freezing.
     *
     * @param celsius Temperature in Celsius.
     * @return True if the temperature is 0°C or below.
     */
    private fun isFreezing(celsius: Int): Boolean {
        return celsius <= 0
    }

    /**
     * Calculates the average temperature.
     *
     * @param values List of temperature values.
     * @return Average temperature.
     */
    private fun averageTemperature(values: List<Int>): Double {
        return values.average()
    }

    /**
     * Returns the highest temperature from the list.
     *
     * @param values List of temperatures.
     * @return Highest temperature.
     */
    private fun highestTemperature(values: List<Int>): Int {
        return values.maxOrNull() ?: 0
    }

    /**
     * Returns the lowest temperature from the list.
     *
     * @param values List of temperatures.
     * @return Lowest temperature.
     */
    private fun lowestTemperature(values: List<Int>): Int {
        return values.minOrNull() ?: 0
    }

    companion object {
        private const val KEY_TEMP = "key_temperature"
    }
}