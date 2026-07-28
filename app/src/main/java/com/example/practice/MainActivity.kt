package com.example.practice

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.model.UserProfile
import com.google.android.material.button.MaterialButton

/**
 * MainActivity - User Score & Level Practice Screen
 */
class MainActivity : AppCompatActivity() {

    private var currentScore = 0
    private lateinit var tvUserProfile: TextView
    private lateinit var tvScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUserProfile = findViewById(R.id.tvUserProfile)
        tvScore = findViewById(R.id.tvScore)
        val btnAddPoints = findViewById<MaterialButton>(R.id.btnAddPoints)
        val btnResetScore = findViewById<MaterialButton>(R.id.btnResetScore)

        if (savedInstanceState != null) {
            currentScore = savedInstanceState.getInt(KEY_SCORE, 0)
        }

        updateUI()

        btnAddPoints.setOnClickListener {
            currentScore += 10
            updateUI()
        }

        btnResetScore.setOnClickListener {
            currentScore = 0
            updateUI()
            Toast.makeText(this, getString(R.string.msg_score_reset), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE, currentScore)
    }

    private fun updateUI() {
        val level = when {
            currentScore >= 50 -> "Pro"
            currentScore >= 20 -> "Intermediate"
            else -> "Beginner"
        }
        val userProfile = UserProfile(username = "Developer", score = currentScore, level = level)
        tvUserProfile.text = "Welcome, ${userProfile.username}! (${userProfile.getBadge()})"
        tvScore.text = userProfile.getFormattedScore()
    }

    companion object {
        private const val KEY_SCORE = "key_score"
    }
}
