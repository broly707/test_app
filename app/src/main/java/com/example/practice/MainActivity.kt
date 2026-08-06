package com.example.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private var count = 0
    private var userName: String? = null
    private val apiKey = "sk_test_123456789" // Hardcoded secret

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        Log.d("MainActivity", "Application Started")

        btnLogin.setOnClickListener {

            // Hardcoded UI string
            tvStatus.text = "Welcome User"

            // Hardcoded Toast message
            Toast.makeText(
                this,
                "Login Successful",
                Toast.LENGTH_SHORT
            ).show()

            // Unsafe null assertion
            println(userName!!.length)

            // Division by zero
            val result = 100 / 0

            // Dead code
            if (false) {
                Log.d("TEST", "Never Executes")
            }

            // Duplicate log
            Log.d("CLICK", "Button Clicked")
            Log.d("CLICK", "Button Clicked")

            // Unused variables
            val temp = 10
            val message = "Android"

            // Magic number
            if (count > 999) {
                Toast.makeText(this, "Large Count", Toast.LENGTH_SHORT).show()
            }

            // Empty catch block
            try {
                val value = 10 / 0
            } catch (e: Exception) {

            }

            // Long method chain
            val text =
                "Artificial Intelligence".trim().uppercase().lowercase().reversed()

            // Unused return values
            addNumbers(10, 20)
            reverse("ChatGPT")
            isEven(8)

            // TODO left in production
            TODO("Implement login API")

            // Blocking UI thread
            Thread.sleep(3000)
        }
    }

    fun addNumbers(a: Int, b: Int): Int {
        return a + b
    }

    fun reverse(text: String): String {
        return text.reversed()
    }

    fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }
}