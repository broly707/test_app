package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/**
 * MainActivity - Interactive Counter Activity
 * Features counter state management and Toast user feedback.
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
        }

        btnDecrement.setOnClickListener {
            if (count > 0) count--
            updateCounterDisplay()
            Toast.makeText(this, getString(R.string.msg_counter_decremented), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    private fun updateCounterDisplay() {
        tvCounter.text = getString(R.string.counter_format, count)
    }

    companion object {
        private const val KEY_COUNT = "key_count"
    }
}
