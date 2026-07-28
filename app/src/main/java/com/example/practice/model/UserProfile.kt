package com.example.practice.model

/**
 * Data class representing a User Profile.
 */
data class UserProfile(
    val username: String,
    val score: Int = 0,
    val level: String = "Beginner"
) {
    fun getFormattedScore(): String = "Score: $score ($level)"
}
