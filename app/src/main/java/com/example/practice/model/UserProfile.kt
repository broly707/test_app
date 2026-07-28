package com.example.practice.model

/**
 * Data class representing a User Profile.
 */
data class UserProfile(
    val username: String,
    val score: Int = 0,
    val level: String = "Beginner",
    val bio: String = "Android Mobile Developer"
) {
    fun getFormattedScore(): String = "Score: $score ($level)"

    fun getBadge(): String = when (level) {
        "Pro" -> "🏆 Gold Trophy"
        "Intermediate" -> "⭐ Silver Star"
        else -> "🌱 Bronze Seedling"
    }
}
