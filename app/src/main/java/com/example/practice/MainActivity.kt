package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * MainActivity displays a simple student grade calculator.
 *
 * Responsibilities:
 * - Increases and decreases marks.
 * - Calculates grades.
 * - Displays pass/fail status.
 * - Saves marks during configuration changes.
 *
 * Note:
 * This class contains several utility methods for
 * demonstration and AI testing purposes.
 */
class MainActivity : AppCompatActivity() {

    private var marks = 50
    private lateinit var tvMarks: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMarks = findViewById(R.id.tvText)

        val btnIncrease = findViewById<MaterialButton>(R.id.btnIncrement)
        val btnDecrease = findViewById<MaterialButton>(R.id.btnDecrement)

        if (savedInstanceState != null) {
            marks = savedInstanceState.getInt(KEY_MARKS, 50)
        }

        updateMarks()

        btnIncrease.setOnClickListener {
            if (marks < 100) {
                marks += 5
            }

            updateMarks()

            Toast.makeText(
                this,
                "Marks Increased",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnDecrease.setOnClickListener {
            if (marks > 0) {
                marks -= 5
            }

            updateMarks()

            Toast.makeText(
                this,
                "Marks Decreased",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Sample method calls
        calculateGrade(marks)
        isPassed(marks)
        calculatePercentage(450, 500)
        findAverage(listOf(80, 75, 90, 95))
        getHighestMark(listOf(55, 78, 89, 96))
        getLowestMark(listOf(55, 78, 89, 96))
        capitalizeName("mahendra")
        sortMarks(mutableListOf(60, 90, 75, 45))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_MARKS, marks)
    }

    /**
     * Updates the marks displayed on screen.
     */
    private fun updateMarks() {
        tvMarks.text = "Marks: $marks"
    }

    /**
     * Returns the grade based on marks.
     */
    private fun calculateGrade(marks: Int): String {
        return when {
            marks >= 90 -> "A"
            marks >= 80 -> "B"
            marks >= 70 -> "C"
            marks >= 60 -> "D"
            else -> "F"
        }
    }

    /**
     * Returns true if student has passed.
     */
    private fun isPassed(marks: Int): Boolean {
        return marks >= 35
    }

    /**
     * Calculates percentage.
     */
    private fun calculatePercentage(obtained: Int, total: Int): Double {
        return (obtained.toDouble() / total) * 100
    }

    /**
     * Returns average marks.
     */
    private fun findAverage(marks: List<Int>): Double {
        return marks.average()
    }

    /**
     * Returns highest mark.
     */
    private fun getHighestMark(marks: List<Int>): Int {
        return marks.maxOrNull() ?: 0
    }

    /**
     * Returns lowest mark.
     */
    private fun getLowestMark(marks: List<Int>): Int {
        return marks.minOrNull() ?: 0
    }

    /**
     * Capitalizes the student's name.
     */
    private fun capitalizeName(name: String): String {
        return name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase() else it.toString()
        }
    }

    /**
     * Sorts marks in ascending order.
     */
    private fun sortMarks(list: MutableList<Int>) {
        list.sort()
    }

    companion object {
        private const val KEY_MARKS = "key_marks"
    }
}