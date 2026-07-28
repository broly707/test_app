package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.utils.CounterHelper
import com.google.android.material.button.MaterialButton

/**
 * MainActivity - Interactive Counter App with CounterHelper
 */
class MainActivity : AppCompatActivity() {

    private lateinit var counterHelper: CounterHelper
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialCount = savedInstanceState?.getInt(KEY_COUNT, 0) ?: 0
        counterHelper = CounterHelper(initialCount)

        tvCounter = findViewById(R.id.tvCounter)
        val btnIncrement = findViewById<MaterialButton>(R.id.btnIncrement)
        val btnDecrement = findViewById<MaterialButton>(R.id.btnDecrement)
        val btnReset = findViewById<MaterialButton>(R.id.btnReset)

        updateCounterDisplay()

        btnIncrement.setOnClickListener {
            counterHelper.increment()
            updateCounterDisplay()
        }

        btnDecrement.setOnClickListener {
            counterHelper.decrement()
            updateCounterDisplay()
        }

        btnReset.setOnClickListener {
            counterHelper.reset()
            updateCounterDisplay()
            Toast.makeText(this, getString(R.string.msg_reset), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, counterHelper.getCount())
    }

    private fun updateCounterDisplay() {
        tvCounter.text = counterHelper.getCount().toString()
    }

    companion object {
        private const val KEY_COUNT = "key_count"
    }
}
