package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.data.DashboardRepository
import com.google.android.material.button.MaterialButton

/**
 * MainActivity - Interactive Practice App with User Dashboard
 * // Trigger AI PR review update
 */
class MainActivity : AppCompatActivity() {

    private var currentScore = 0
    private val repository = DashboardRepository()

    private lateinit var tvWelcome: TextView
    private lateinit var tvLevelValue: TextView
    private lateinit var tvPointsValue: TextView
    private lateinit var tvTasksValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvLevelValue = findViewById(R.id.tvLevelValue)
        tvPointsValue = findViewById(R.id.tvPointsValue)
        tvTasksValue = findViewById(R.id.tvTasksValue)

        val btnAddPoints = findViewById<MaterialButton>(R.id.btnAddPoints)
        val btnReset = findViewById<MaterialButton>(R.id.btnReset)

        if (savedInstanceState != null) {
            currentScore = savedInstanceState.getInt(KEY_SCORE, 0)
        }

        renderDashboard()

        btnAddPoints.setOnClickListener {
            currentScore += 10
            renderDashboard()
        }

        btnReset.setOnClickListener {
            currentScore = 0
            renderDashboard()
            Toast.makeText(this, getString(R.string.msg_reset), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE, currentScore)
    }

    private fun renderDashboard() {
        val metrics = repository.getMetrics(currentScore)
        tvWelcome.text = getString(R.string.welcome_title)

        metrics.forEach { item ->
            when (item.id) {
                1 -> tvLevelValue.text = "${item.iconSymbol} ${item.value}"
                2 -> tvPointsValue.text = "${item.iconSymbol} ${item.value}"
                3 -> tvTasksValue.text = "${item.iconSymbol} ${item.value}"
            }
        }
    }

    companion object {
        private const val KEY_SCORE = "key_score"
    }
}
