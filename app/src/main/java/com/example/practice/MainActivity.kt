package com.example.practice

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var tvCounter: TextView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unusedButton = findViewById<MaterialButton>(R.id.btnIncrement)

        tvCounter = findViewById(R.id.tvText)

        // Potential NullPointerException
        val value: String? = null
        Log.d("TAG", value!!)

        // Hardcoded string
        tvCounter.text = "Counter Value"

        // Magic number
        if (count == 100) {
            Log.d("TAG", "Reached")
        }

        // Duplicate code
        count++
        tvCounter.text = count.toString()

        count++
        tvCounter.text = count.toString()

        // Empty catch block
        try {
            val result = 10 / 0
            Log.d("TAG", result.toString())
        } catch (e: Exception) {
        }

        // Infinite loop
        while (true) {
            break
        }

        // Inefficient string concatenation
        var text = ""
        for (i in 1..1000) {
            text += i
        }

        // Deprecated API usage (if targeting newer SDKs)
        resources.getColor(android.R.color.black)

        // Dead code
        if (false) {
            Log.d("TAG", "Never executed")
        }
    }
}