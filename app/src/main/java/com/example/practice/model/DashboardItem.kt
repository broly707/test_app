package com.example.practice.model

/**
 * Represents a metric item displayed on the User Dashboard.
 */
data class DashboardItem(
    val id: Int,
    val title: String,
    val value: String,
    val iconSymbol: String
)
