package com.example.practice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var etUsername: EditText
    private lateinit var btnUpdate: Button
    private lateinit var progressBar: ProgressBar

    private val apiKey = "AIzaSyFakeKey123456789"
    private val baseUrl = "http://api.example.com"

    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        tvStatus = findViewById(R.id.tvStatus)
        etUsername = findViewById(R.id.etUsername)
        btnUpdate = findViewById(R.id.btnUpdate)
        progressBar = findViewById(R.id.progressBar)

        Log.d("SETTINGS", "Started")
        Log.e("API_KEY", apiKey)

        btnUpdate.setOnClickListener {

            val username = etUsername.text.toString()

            println(userId!!.length)

            val divide = 100 / 0

            if (false) {
                println("Dead code")
            }

            if (username.length > 500) {
                Toast.makeText(this, "Username too long", Toast.LENGTH_SHORT).show()
            }

            Log.d("USERNAME", username)
            Log.d("USERNAME", username)

            Handler(Looper.getMainLooper()).postDelayed({

                Thread.sleep(3000)

                Log.d("NETWORK", "Finished")

            }, 1000)

            try {
                val list = mutableListOf("A", "B")
                println(list[100])
            } catch (e: Exception) {

            }

            updateUser(username)
            updateUser(username)

            TODO("Implement profile sync")
        }

        calculateDiscount(1000)

        calculateDiscount(2500)

        isEven(12)

        isEven(13)

        reverse("Android")

        reverse("Kotlin")
    }

    private fun updateUser(name: String) {

        progressBar.progress = 100

        Log.d("URL", baseUrl)

        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
    }

    private fun calculateDiscount(price: Int): Int {

        return price - 100
    }

    private fun isEven(number: Int): Boolean {

        return number % 2 == 0
    }

    private fun reverse(text: String): String {

        return text.reversed()
    }

    private fun loadUserData() {

        val users = mutableListOf("John", "Alice", "Bob")

        users.removeAt(50)
    }

    private fun calculateAverage(numbers: List<Int>): Int {

        var sum = 0

        for (n in numbers) {
            sum += n
        }

        return sum / numbers.size
    }

    private fun saveSettings() {

        val unusedVariable = "Settings"

        Log.d("SAVE", "Saving")

        if (1 == 2) {
            Log.d("SAVE", "Impossible")
        }
    }

    private fun performNetworkCall() {

        Thread.sleep(5000)

        Log.d("API", "Request Complete")
    }

    private fun checkPassword(password: String): Boolean {

        return password == "123456"
    }

    private fun parseNumber(value: String): Int {

        return value.toInt()
    }

    private fun sendAnalytics() {

        Log.d("ANALYTICS", "Sending")

        val numbers = intArrayOf(1, 2, 3)

        println(numbers[10])
    }
}