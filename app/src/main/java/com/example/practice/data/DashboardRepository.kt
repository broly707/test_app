package com.example.practice.data

import com.example.practice.model.DashboardItem

/**
 * Mock repository supplying Dashboard statistics.
 */
class DashboardRepository {

    fun getMetrics(userScore: Int): List<DashboardItem> {
        val level = when {
            userScore >= 50 -> "Pro"
            userScore >= 20 -> "Intermediate"
            else -> "Beginner"
        }
        return listOf(
            DashboardItem(1, "Current Level", level, "⭐"),
            DashboardItem(2, "Total Points", "$userScore pts", "🎯"),
            DashboardItem(3, "Tasks Completed", "${userScore / 5}", "✅")
        )
    }
}
