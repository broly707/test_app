package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvCounter)
        val btnIncrement = findViewById<MaterialButton>(R.id.btnIncrement)
        val btnDecrement = findViewById<MaterialButton>(R.id.btnDecrement)
        val btnReset = findViewById<MaterialButton>(R.id.btnReset)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0)
        }
        updateCounterDisplay()

        btnIncrement.setOnClickListener {
            count++
            updateCounterDisplay()
        }

        btnDecrement.setOnClickListener {
            count--
            updateCounterDisplay()
        }

        btnReset.setOnClickListener {
            count = 0
            updateCounterDisplay()
            Toast.makeText(this, getString(R.string.msg_reset), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    private fun updateCounterDisplay() {
        tvCounter.text = count.toString()
    }

    companion object {
        private const val KEY_COUNT = "key_count"
    }
}
